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
                          .map(x -> new MineItem())
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
                             .map(x -> 
                             {
                                 if(x.x() < 0) return null;
                                 if(x.x() >= this.width) return null;
                                 if(x.y() < 0) return null;
                                 if(x.y() >= this.height) return null;
                                 return mineItems.get(x.x() + x.y() * width);
                             });
    }
}

record Tuple(int x, int y){}