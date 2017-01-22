package pragmatists.elevator;

public class Elevator implements ObserverBoard{

    private State state;
    private int currentFloor;
    private int targetFloor;

    public enum State {GOINGUP, WAITING, GOINGDOWN, MAINTENANCE}

    public Elevator (DriverBoard board) {
        this.state =  State.WAITING;
        this.currentFloor = 0;
        this.targetFloor = 0;
    }


    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public State getState() {
        return this.state;
    }


    public void reach(int floor) {
        if (this.state == State.MAINTENANCE) {
            return;
        }
        if (floor == this.targetFloor) {
            this.state = State.WAITING;
        }
        this.currentFloor = floor;
    }

    public void errorEngine() {
        this.state = State.MAINTENANCE;

    }

    public void errorCloseDoors() {
        this.state = State.MAINTENANCE;
    }

    public void pushButton(int buttonFloor, int targetFloor) {
        this.targetFloor = targetFloor;
        if (targetFloor > this.currentFloor) {
            this.state = State.GOINGUP;
        } else if (targetFloor < this.currentFloor) {
            this.state = State.GOINGDOWN;
        }
    }


}

