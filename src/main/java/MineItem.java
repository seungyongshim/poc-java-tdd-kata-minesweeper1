import java.util.function.Function;

public class MineItem {
    private int number;
    private boolean isBomb;
    private boolean isCover = true;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return isCover ? "." :
               isBomb ? "*" : 
               Integer.toString(number);
    }

    public void setBomb() {
        isBomb = true;
    }

	public void click() {
        isCover = false;
	}
}
