public class Lift {

    private int currentFloor;
    public Lift () {
        this.currentFloor = 0;
    }

    public Lift(int floor) {
        this.currentFloor = floor;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void pusbButton(int floor) {
        this.currentFloor = floor;
    }
}
