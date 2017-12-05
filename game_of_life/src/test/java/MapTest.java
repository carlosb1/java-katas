import java.util.List;
import models.Cellula;
import models.Map;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MapTest {

    public static final Map addCellula(final Map map, final Cellula cellula ) {
        List<Cellula> cellulas = Arrays.asList(cellula);
        return new Map(cellulas);
    }



    @Test
    public void should_initialize_without_cellula () {
        final Map map = new Map();
        assertEquals(0,map.cellulas.size());
    }
    @Test
    public void should_initialize_one_cellula_after_dead () {
        final Map map = new Map();
        final Map  newMap = addCellula(map,new Cellula(0,0));
        assertEquals(1,newMap.cellulas.size());
    }








}
