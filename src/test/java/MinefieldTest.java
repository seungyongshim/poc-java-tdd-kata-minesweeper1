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

}
