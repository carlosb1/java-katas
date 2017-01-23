package pragmatists.elevator;

/**
 * Created by carlos on 1/22/17.
 */
import java.lang.Integer;

public class Elevator2 {

    private int currentFloor;
    private int endFloor;
    private Board board;
    public Elevator2(Board board) {
        currentFloor = 0;
        endFloor = 0;
        board = board;
    }

    public void run(int sourceFloor, int targetFloor) {
//        List<Integer> floors =
        while (currentFloor< endFloor) {
            List<Integer> floors = board.getPushedButtons();
            updateVisitFloors(floors);
            List<Error> this.board.getErrors();
            this.board.moveUp();

        }
    }


}
