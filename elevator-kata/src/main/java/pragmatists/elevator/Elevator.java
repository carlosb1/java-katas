package pragmatists.elevator;

import java.util.LinkedList;

public class Elevator implements ObserverBoard{

    private State state;
    private int currentFloor;
    private int targetFloor;
    LinkedList<Integer[]> pressedButtons;
    private Engine engine;

    public enum State {GOINGUP, WAITING, GOINGDOWN, MAINTENANCE}

    public Elevator (Engine engine) {
        this.state =  State.WAITING;
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.engine = engine;
        this.pressedButtons = new LinkedList<Integer[]>();
    }



    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public State getState() {
        return this.state;
    }



    public void start() {
            for (int i = 0; i < this.pressedButtons.size(); i++) {
                if (this.state == State.MAINTENANCE) {
                    return;
                }
                Integer [] pressedButton = this.pressedButtons.get(i);
                if (this.currentFloor == this.targetFloor) {
                    this.state = State.WAITING;
                }

                this.targetFloor = pressedButton[1];
                if (targetFloor > this.currentFloor) {
                    this.state = State.GOINGUP;
                } else if (targetFloor < this.currentFloor) {
                    this.state = State.GOINGDOWN;
                }

                //TODO can throws error from the engine
                engine.move(currentFloor,pressedButton[1]);
                this.currentFloor = pressedButton[1];
            }
            this.state = State.WAITING;

    }


    public void errorEngine() {
        this.state = State.MAINTENANCE;
    }

    public void errorCloseDoors() {
        this.state = State.MAINTENANCE;
    }

    public void pressButton(int buttonFloor, int targetFloor) {
        Integer [] pressedButton = {buttonFloor, targetFloor};
        this.pressedButtons.add(pressedButton);
        if (this.state == State.WAITING) {
            this.start();
        }

    }


}

