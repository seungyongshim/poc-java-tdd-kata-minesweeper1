import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinefieldTest {
    @Test
    void should_Create_3x3()
    {
        // arrange
        var sut = new Minefield(3, 3);

        // act

        // assert
        assertEquals(9, sut.getMineItems().size());
    }

    @Test
    void should_set_bombs()
    {
        var sut = new Minefield(3, 3, 3);

        assertEquals(sut.getMineItems()
                        .stream()
                        .filter(x -> x.isBomb())
                        .count(), 3);
    }

}
