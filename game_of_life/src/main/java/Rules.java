import models.Cellula;
import models.Map;
import models.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rules {

    public static final Map addCellula(final Map map, final Cellula... arrayCellulas ) {
        final List<Cellula> cellulas = Arrays.asList(arrayCellulas);
        return new Map(cellulas);
    }

    public static final  Map play(final Map map) {
        final List<Cellula> cellulas = new ArrayList<>();
        for (Cellula cellula: map.cellulas) {
            List<Position> positionsToSearch = setUpPosicForNeighbours(cellula.x, cellula.y);
            long numberNeighBours = positionsToSearch.stream().filter(position -> hasItNeighbour(position, map.cellulas)).count();

            if (isLiveCellula(numberNeighBours)) {
                cellulas.add(new Cellula(cellula.x, cellula.y));
            }

        }

        return new Map(cellulas);

    }

    private static boolean hasItNeighbour(Position position, List<Cellula> cellulas) {
        return cellulas.stream().filter(cellulaToCompare -> cellulaToCompare.x == position.x && cellulaToCompare.y == position.y).count() >0;

    }

    private static List<Position> setUpPosicForNeighbours(Integer x, Integer y) {
        return Arrays.asList(new Position(x - 1, y - 1), new Position(x, y - 1), new Position(x + 1, y - 1), new Position(x - 1, y + 1), new Position(x, y + 1), new Position(x + 1, y + 1), new Position(x - 1, y), new Position(x + 1, y));
    }

    private static boolean isLiveCellula(long numberNeighBours) {
        return numberNeighBours == 2 || numberNeighBours == 3;
    }

    }
