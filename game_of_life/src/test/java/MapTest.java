import java.util.ArrayList;
import java.util.List;
import models.Cellula;
import models.Map;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MapTest {
    public static class Position {
        protected final int x;
        protected final int y;
        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final Map addCellula(final Map map, final Cellula ... arrayCellulas ) {
        final List<Cellula> cellulas = Arrays.asList(arrayCellulas);
        return new Map(cellulas);
    }

    public static final  Map play(final Map map) {
        final List<Cellula> cellulas = new ArrayList<>();
        for (Cellula cellula: map.cellulas) {
            Integer x = cellula.x;
            Integer y = cellula.y;
            //TODO abstract this function
            List<Position> positionsToSearch = Arrays.asList(new Position(x - 1, y - 1), new Position(x, y - 1), new Position(x + 1, y - 1), new Position(x - 1, y + 1), new Position(x, y + 1), new Position(x + 1, y + 1), new Position(x - 1, y), new Position(x + 1, y));

            int numberNeighBours = 0;
            for (Position position : positionsToSearch) {
                for (Cellula cellulaToCompare : map.cellulas) {
                    if (cellulaToCompare.x == position.x && cellulaToCompare.y == position.y) {
                        numberNeighBours++;
                    }
                }
            }
            if (numberNeighBours == 2 || numberNeighBours == 3) {
                cellulas.add(new Cellula(cellula.x, cellula.y));
            }
        }

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

    @Test
    public void should_initialize_three_cellulas_play_and_live () {
        final Map map = new Map();
        final Map  newMap = play(addCellula(map,new Cellula(0,0),new Cellula(1,0),new Cellula(1,1)));
        assertEquals(3,newMap.cellulas.size());
    }











}
