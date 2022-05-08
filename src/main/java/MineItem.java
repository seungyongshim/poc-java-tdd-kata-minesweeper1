public class MineItem {
    private int number;
    private boolean isBomb;
    private boolean isCover = true;
    private int x;
    private int y;

    public MineItem() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public MineItem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

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

    public boolean isBomb() {
        return isBomb;
    }
}
