import java.util.ArrayList;
import java.util.List;

public class Minefield {
    public Minefield(int i, int j) {
        mineItems = new ArrayList<>(i * j);
    }

    List<MineItem> mineItems;

    public List<MineItem> getMineItems() {
        return mineItems;
    }
}
