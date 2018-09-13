public class EngineDriver {

    private int currentFloor;
    private Status status = Status.STOPPED;

    /* trigger from hardware */
    public void onArrive(int floor) {
        this.currentFloor = floor;
    }
    public void onStatus(Status status) {
        this.status = status;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Status getStatus() {
        return status;
    }



    public void start() {
        this.status = Status.MOVING;
    }

    public enum Status {STOPPED, MOVING, OPEN_DOORS
    }
}
