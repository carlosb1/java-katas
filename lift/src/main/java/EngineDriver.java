public class EngineDriver {

    private int currentFloor;

    public void onArrive(int floor) {
        this.currentFloor = floor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
