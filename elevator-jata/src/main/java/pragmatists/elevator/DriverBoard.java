package pragmatists.elevator;

/**
 * Created by carlos on 1/22/17.
 */
public interface DriverBoard {
    void throwsErrorDoor();
    void throwsErrorEngine();
    void pushButton(int currentFloor, int targetFloor);
    void reachFloor(int floor);
}
