import com.sun.xml.internal.ws.api.pipe.Engine;

public class Lift {

    private int currentFloor;
    private EngineDriver engineDriver;

    public Lift(int floor, EngineDriver engineDriver) {
        this.currentFloor = floor;
        this.engineDriver = engineDriver;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void pushButton(int floor) {
        this.currentFloor = floor;
        engineDriver.start();
    }

    public Action getAction() {
        if (this.engineDriver.getStatus() == EngineDriver.Status.OPEN_DOORS) {
            return Action.OPEN_DOORS;
        }
        return Action.Up;
    }
}
