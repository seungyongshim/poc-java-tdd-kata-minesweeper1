import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Minefield {
    List<MineItem> mineItems;

    public Minefield(int width, int height, int bombs) {
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
        
	}
}
