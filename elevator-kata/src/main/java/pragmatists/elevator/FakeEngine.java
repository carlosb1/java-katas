package pragmatists.elevator;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by carlos on 1/27/17.
 */
public class FakeEngine implements Engine {
    private final DriverBoard board;
    private final Queue<List<Integer[]>> queueButtons;
    public FakeEngine(DriverBoard board) {
        this.board = board;
        this.queueButtons = new PriorityQueue<List<Integer[]>>();
    }

    public void addPressedButtons(List<Integer[]> buttons) {
            this.queueButtons.add(buttons);
    }

    @Override
    public void move(Integer fromFloor, Integer toFloor) {

        List<Integer[]> setButtons = this.queueButtons.poll();
        if (setButtons!=null) {
            for (Integer[] buttons: setButtons) {
                board.pushButton(buttons[0],buttons[1]);
            }
        }


    }
}
