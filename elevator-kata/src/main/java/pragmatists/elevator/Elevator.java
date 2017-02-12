package pragmatists.elevator;

import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Elevator{

    private State state;
    private int currentFloor;
    private int targetFloor;
    List<Integer> pressedButtons;
    private Engine engine;

    public enum State {GOINGUP, WAITING, GOINGDOWN, MAINTENANCE}

    public Elevator () {
        this(0);
    }
    public Elevator (int currentFloor) {
        this.state =  State.WAITING;
        this.currentFloor = currentFloor;
        this.targetFloor = 0;
        this.engine = new FakeEngine();
        this.pressedButtons = new LinkedList<Integer>();
    }

    public void setEngine(Engine engine )  {
        this.engine = engine;
    }



    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public State getState() {
        return this.state;
    }


    public void errorEngine() {
        this.state = State.MAINTENANCE;
    }

    public void errorCloseDoors() {
        this.state = State.MAINTENANCE;
    }

    //TODO no concurrent available
    //TODO apply iterator pattern
    public void addButton(int targetFloor) {
        this.pressedButtons.add(targetFloor);
        this.pressedButtons = this.pressedButtons.stream().sorted().collect(toList());
    }

    public int next() {
        int index = this.pressedButtons.indexOf(currentFloor);
        if (index+1==this.pressedButtons.size()) {
            return -1;
        }
        return  this.pressedButtons.get(index+1);
    }

    private int previous() {
        int index = this.pressedButtons.indexOf(currentFloor);
        if (index-1<0) {
            return -1;
        }
        return this.pressedButtons.get(index-1);
    }

    //TODO discard current button

    public void pressButton (int targetFloor) {
        if (State.WAITING== this.state) {
            this.addButton(targetFloor);
            if (currentFloor < targetFloor) {
                up(targetFloor);
            } else {
                down(targetFloor);
            }
        } else if (State.GOINGUP == this.state && currentFloor < targetFloor) {
            this.addButton(targetFloor);
        } else if (State.GOINGDOWN == this.state && currentFloor > targetFloor) {
            this.addButton(targetFloor);
        }
    }


    public void up(int targetFloor) {
        this.state = State.GOINGUP;
        if (targetFloor > this.targetFloor) {
            this.targetFloor = targetFloor;
        }
        int nextFloor = next();
        while (nextFloor!=-1) {
            this.engine.move(currentFloor,nextFloor);
            if (this.state == State.MAINTENANCE) {
                return;
            }
            this.currentFloor = nextFloor;
            nextFloor = next();
        }
        this.state = State.WAITING;
    }

    public void down(int targetFloor) {
        this.state = State.GOINGDOWN;
        if (targetFloor < this.targetFloor) {
            this.targetFloor = targetFloor;
        }
        int previousFloor = previous();
        while (previousFloor!=-1) {
            this.engine.move(currentFloor,previousFloor);
            if (this.state == State.MAINTENANCE) {
                return;
            }
            this.currentFloor = previousFloor;
            previousFloor = previous();
        }
        this.state = State.WAITING;
    }

}

