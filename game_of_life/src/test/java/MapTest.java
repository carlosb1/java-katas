import java.util.ArrayList;
import java.util.List;
import models.Cellula;
import models.Map;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MapTest {

    public static final Map addCellula(final Map map, final Cellula ... arrayCellulas ) {
        final List<Cellula> cellulas = Arrays.asList(arrayCellulas);
        return new Map(cellulas);
    }

    public static final  Map play(final Map map) {
        final List<Cellula> cellulas = new ArrayList<>();
        //TODO abstract this function
        return new Map(cellulas);

    }





    @Test
    public void should_initialize_without_cellula () {
        final Map map = new Map();
        assertEquals(0,map.cellulas.size());
    }
    @Test
    public void should_initialize_one_cellula () {
        final Map map = new Map();
        final Map  newMap = addCellula(map,new Cellula(0,0));
        assertEquals(1,newMap.cellulas.size());
    }

    @Test
    public void should_initialize_one_cellula_play_and_dead () {
        final Map map = new Map();
        final Map  newMap = play(addCellula(map,new Cellula(0,0)));
        assertEquals(0,newMap.cellulas.size());
    }


    @Test
    public void should_initialize_two_separated_cellulas_play_and_dead () {
        final Map map = new Map();
        final Map  newMap = play(addCellula(map,new Cellula(0,0),new Cellula(0,1)));
        assertEquals(0,newMap.cellulas.size());
    }







}
