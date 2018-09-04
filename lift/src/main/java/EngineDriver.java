public class EngineDriver {

    private int currentFloor;
    private Status status = Status.STOPPED;

    public void onArrive(int floor) {
        this.currentFloor = floor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Status getStatus() {
        return status;
    }

    public void onStatus(Status status) {
        this.status = status;
    }

    public enum Status {STOPPED, MOVING}
}
