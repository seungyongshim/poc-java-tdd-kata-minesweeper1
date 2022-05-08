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
                 .filter(x -> x.isBomb());
	}

    public Stream<MineItem> nearItems(MineItem item)
    {
        var builder = Stream.<MineItem>builder();

        // 튜플이 없어!!!!

        builder.add(item);

        return builder.build();
    }
}
