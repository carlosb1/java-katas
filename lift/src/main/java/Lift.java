public class Lift {

    private int currentFloor;
    public Lift () {
        this.currentFloor = 0;
    }

    public Lift(int floor) {
        this.currentFloor = floor;
    }

    //TODO change name for current floor
    public int getFloor() {
        return this.currentFloor;
    }

    public void pusbButton(int floor) {
        this.currentFloor = floor;
    }
}
