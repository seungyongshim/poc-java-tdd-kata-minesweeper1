import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Minefield {
    List<MineItem> mineItems;
    int width;
    int height;

    public Minefield(int width, int height, int bombs) {
        this.width = width;
        this.height = height;

        mineItems = Stream.iterate(0, n -> n + 1)
                          .limit(width * height)
                          .map(x -> new MineItem(x % width, x / width))
                          .toList();
        
        new Random().ints(0, width * height)
                    .distinct()
                    .limit(bombs)
                    .forEach(i -> mineItems.get(i).setBomb());
    }

    public Minefield(int width, int height) {
        this(width, height, 0);
    }

    public List<MineItem> getMineItems() {
        return mineItems;
    }

	public void calcNearBombs() {
        mineItems.stream()
                 .filter(x -> x.isBomb())
                 .forEach(x -> nearItems(x).forEach(MineItem::addNumber));
	}

    public Stream<MineItem> nearItems(MineItem item)
    {
        // 튜플이 없어!!!!
        var builderPosNear = Stream.<Tuple>builder();
        builderPosNear.add(new Tuple(item.getX() - 1, item.getY() - 1));
        builderPosNear.add(new Tuple(item.getX() , item.getY() - 1));
        builderPosNear.add(new Tuple(item.getX() + 1, item.getY() - 1));
        builderPosNear.add(new Tuple(item.getX() - 1, item.getY() ));
        builderPosNear.add(new Tuple(item.getX() + 1, item.getY() ));
        builderPosNear.add(new Tuple(item.getX() - 1, item.getY() + 1));
        builderPosNear.add(new Tuple(item.getX() , item.getY() + 1));
        builderPosNear.add(new Tuple(item.getX() + 1, item.getY() + 1));
        
        return builderPosNear.build()
                             .map(i -> 
                             {
                                 if(i.x() < 0) return null;
                                 if(i.x() >= this.width) return null;
                                 if(i.y() < 0) return null;
                                 if(i.y() >= this.height) return null;
                                 return mineItems.get(i.x() + i.y() * width);
                             })
                             .filter(x -> x != null);
    }
}

record Tuple(int x, int y){}