import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Minefield {
    public Minefield(int i, int j) {
        mineItems = Stream.iterate(0, n -> n + 1)
                          .limit(i * 9)
                          .map(x -> new MineItem())
                          .toList();
    }

    List<MineItem> mineItems;

    public List<MineItem> getMineItems() {
        return mineItems;
    }
}
