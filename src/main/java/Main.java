import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(add().apply(3).apply(4));
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(pure = true)
    public static Function<Integer, Function<Integer, Integer>> add() {
        return x -> y -> x + y;
    }
}
