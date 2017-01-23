package pragmatists.elevator;

/**
 * Created by carlos on 1/22/17.
 */
public interface ObserverBoard {
     void errorEngine();
     void errorCloseDoors();
     void pressButton(int currentFloor, int targetFloor);
}
