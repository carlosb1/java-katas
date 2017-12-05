import models.Cellula;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {



    @Test
    public void should_initialize_without_cellula () {
        GameOfLife gameOfLife = new GameOfLife();
        assertEquals(0,gameOfLife.cellulas());
    }
    @Test
    public void should_initialize_one_cellula_after_dead () {
        //TODO move to setup
        //TODO move to map
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.addCellula(new Cellula(0,0));
        assertEquals(1,gameOfLife.cellulas());
    }




}
