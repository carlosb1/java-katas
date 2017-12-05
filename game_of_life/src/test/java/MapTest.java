
import models.Cellula;
import models.Map;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class MapTest {





    @Test
    public void should_initialize_without_cellula () {
        final Map map = new Map();
        assertEquals(0,map.cellulas.size());
    }
    @Test
    public void should_initialize_one_cellula () {
        final Map map = new Map();
        final Map  newMap = Rules.addCellula(map,new Cellula(0,0));
        assertEquals(1,newMap.cellulas.size());
    }

    @Test
    public void should_initialize_one_cellula_play_and_dead () {
        final Map map = new Map();
        final Map  newMap = Rules.play(Rules.addCellula(map,new Cellula(0,0)));
        assertEquals(0,newMap.cellulas.size());
    }


    @Test
    public void should_initialize_two_separated_cellulas_play_and_dead () {
        final Map map = new Map();
        final Map  newMap = Rules.play(Rules.addCellula(map,new Cellula(0,0),new Cellula(0,1)));
        assertEquals(0,newMap.cellulas.size());
    }

    @Test
    public void should_initialize_three_cellulas_play_and_live () {
        final Map map = new Map();
        final Map  newMap = Rules.play(Rules.addCellula(map,new Cellula(0,0),new Cellula(1,0),new Cellula(1,1)));
        assertEquals(3,newMap.cellulas.size());
    }

    @Test
    public void should_initialize_more_three_cellulas_play_and_live () {
        final Map map = new Map();
        final Map  newMap = Rules.play(Rules.addCellula(map,new Cellula(0,0),new Cellula(1,0),new Cellula(1,1),new Cellula(0,1),new Cellula(0,2)));
        assertEquals(3,newMap.cellulas.size());
    }

    @Test
    public void should_initialize_relived_cellulas_play_and_live () {
        final Map map = new Map();
        final Map  nextMap = Rules.play(Rules.addCellula(map,new Cellula(0,0),new Cellula(1,0)));
        final Map  next2Map = Rules.play(Rules.addCellula(nextMap,new Cellula(0,1),new Cellula(1,1),new Cellula(2,1)));
        assertEquals(4,next2Map.cellulas.size());
    }













}
