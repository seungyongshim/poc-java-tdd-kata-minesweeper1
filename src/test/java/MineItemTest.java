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
        sut.click();
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
        sut.click();
        var ret = sut.toString();

        // assert
        assertEquals("*", ret);
    }

    @Test
    void should_cover()
    {
        // arrange
        var sut = new MineItem();

        // act
        var ret = sut.toString();

        // assert
        assertEquals(".", ret);
    }
}