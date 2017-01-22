package pragmatists.elevator;

/**
 * Created by carlos on 1/22/17.
 */
public interface ObserverBoard {
     void reach(int floor);
     void errorEngine();
     void errorCloseDoors();
     void pushButton(int currentFloor, int targetFloor);
}
