import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineItemTest {
    @Test
    void should_number_1()
    {
        // arrange
        var sut = new MineItem();

        // act
        var ret = sut.getNumber();

        // assert
        assertEquals(1, ret);
        //
    }
}