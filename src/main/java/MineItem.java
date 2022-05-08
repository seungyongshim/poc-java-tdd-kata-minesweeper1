import java.util.function.Function;

public class MineItem {
    private int number;
    private boolean isBomb;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return isBomb ? "*" : Integer.toString(number);
    }

    public void setBomb() {
        isBomb = true;
    }
}
