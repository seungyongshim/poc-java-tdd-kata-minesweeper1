import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineItemTest {
    @Test
    void should_number_1()
    {
        // arrange
        var sut = new MineItem();

        // act
        sut.setNumber(1);
        var ret = sut.toString();

        // assert
        assertEquals("1", ret);
    }

    @Test
    void should_bomb()
    {
        // arrange
        var sut = new MineItem();

        // act
        sut.setBomb();
        var ret = sut.toString();

        // assert
        assertEquals("*", ret);
    }
}