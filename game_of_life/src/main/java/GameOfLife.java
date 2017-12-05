import java.util.List;
import models.Cellula;

import java.util.ArrayList;


public class GameOfLife {
    private final List<Cellula> cellulas;
    public GameOfLife () {
        this.cellulas = new ArrayList<Cellula>();
    }
    public int cellulas() {
        return cellulas.size();
    }

    public void addCellula(Cellula cellula) {
        this.cellulas.add(cellula);

    }
}
