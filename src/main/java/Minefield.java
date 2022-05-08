import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Minefield {
    public Minefield(int width, int height, int bombsCount) {
        mineItems = Stream.iterate(0, n -> n + 1)
                          .limit(width * height)
                          .map(x -> new MineItem())
                          .toList();
        new Random().ints(0, width * height)
                    .distinct()
                    .limit(bombsCount)
                    .forEach(i -> mineItems.get(i).setBomb());
    }

    public Minefield(int width, int height) {
        this(width, height, 0);
    }

    List<MineItem> mineItems;

    public List<MineItem> getMineItems() {
        return mineItems;
    }
}
