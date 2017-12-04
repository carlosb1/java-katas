import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {


    @Test
    public void should_initialize_without_cellula () {
        GameOfLife gameOfLife = new GameOfLife();
        assertEquals(0,gameOfLife.cellulas());
    }
}
