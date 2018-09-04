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
        engineDriver.onStatus(EngineDriver.Status.MOVING);
    }

    public Action getAction() {
        return Action.Up;
    }
}
