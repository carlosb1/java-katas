package pragmatists.elevator;

import java.util.List;

/**
 * Created by carlos on 1/22/17.
 */
public class FakeDriverBoard implements DriverBoard {
    private  final ObserverBoard board;

    public FakeDriverBoard(ObserverBoard board) {
        this.board = board;

    }

    public void throwsErrorDoor() {
        this.board.errorCloseDoors();
    }

    public void throwsErrorEngine() {
        this.board.errorEngine();
    }


    public void pushButton(int currentFloor, int targetFloor) {
        this.board.pressButton(currentFloor, targetFloor);
    }





}
