package models;

import java.util.ArrayList;
import java.util.List;


public class Map {
    public final List<Cellula> cellulas;
    public Map(){
        this.cellulas = new ArrayList<>();
    }
    public Map(List<Cellula> cellulas) {
        this.cellulas = cellulas;
    }
}
