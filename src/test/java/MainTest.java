import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest
{
    @Test
    void addSpec() {
        // act
        var ret = Main.add().apply(1).apply(2);

        // asserts
        Assertions.assertEquals(3, ret);
    }
}