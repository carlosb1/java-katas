import models.Cellula;
import models.Map;
import models.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rules {

    public static final Map addCellula(final Map map, final Cellula... newCellulas ) {
        List<Cellula> cellulas = new ArrayList<>();

        for (Cellula newCellula: newCellulas) {
            cellulas.add(newCellula);
        }
        for (Cellula cellula :map.cellulas) {
            cellulas.add(new Cellula(cellula.x,cellula.y,cellula.state));
        }
        return new Map(cellulas);
    }

    public static final  Map play(final Map map) {
        final List<Cellula> cellulas = new ArrayList<>();
        for (Cellula cellula: map.cellulas) {
            List<Position> positionsToSearch = setUpPosicForNeighbours(cellula.x, cellula.y);
            long numberNeighBours = positionsToSearch.stream().filter(position -> hasItNeighbour(position, map.cellulas)).count();

            if (isLiveCellula(numberNeighBours,cellula)) {
                cellulas.add(new Cellula(cellula.x, cellula.y));
            } else if(isRelivedCellula(numberNeighBours,cellula)) {
                cellulas.add(new Cellula(cellula.x, cellula.y));
            } else
            {
                cellulas.add(new Cellula(cellula.x,cellula.y, Cellula.State.Dead));
            }


        }

        return new Map(cellulas);

    }

    private static boolean isRelivedCellula(long numberNeighBours, Cellula cellula) {
        return (cellula.state == Cellula.State.Dead && (numberNeighBours == 3));
    }

    public static List<Cellula> getLivingCellulas(final List<Cellula> cellulas) {
        return cellulas.stream().filter(cellula -> cellula.state== Cellula.State.Live).collect(Collectors.toList());
    }

    private static boolean hasItNeighbour(Position position, List<Cellula> cellulas) {
        return cellulas.stream().filter(cellulaToCompare -> cellulaToCompare.x == position.x && cellulaToCompare.y == position.y && cellulaToCompare.state == Cellula.State.Live).count() >0;

    }

    private static List<Position> setUpPosicForNeighbours(Integer x, Integer y) {
        return Arrays.asList(new Position(x - 1, y - 1), new Position(x, y - 1), new Position(x + 1, y - 1), new Position(x - 1, y + 1), new Position(x, y + 1), new Position(x + 1, y + 1), new Position(x - 1, y), new Position(x + 1, y));
    }

    private static boolean isLiveCellula(long numberNeighBours, Cellula cellula) {
        return (cellula.state == Cellula.State.Live && (numberNeighBours == 2 || numberNeighBours == 3));
    }


}
