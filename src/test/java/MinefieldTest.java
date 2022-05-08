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

    @Test
    void should_calc_near_bombs()
    {
        var sut = new Minefield(3, 3);

        sut.getMineItems().get(1).setBomb();
        sut.getMineItems().get(3).setBomb();

        sut.calcNearBombs();

        assertEquals(2, sut.getMineItems().get(0).getNumber());
    }
}
