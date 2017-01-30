package pragmatists.elevator;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElevatorTest {

    private Elevator elevator;
    @Before
    public void setUp () {
        elevator = new Elevator();
    }


    @Test
    public void givenAnElevatorWhereStartsThenIsInGroundFloor () {
        assertTrue(elevator.getCurrentFloor() == 0);
    }

    @Test
    public void givenAnElevatorWhereStartsThenStateIsWaiting() {
        assertTrue(elevator.getState() == Elevator.State.WAITING);
    }



    //TODO it needs to check build
    @Test
    public void givenAnElevatorWhereStartsAndPushButtonThenIsMoving() {
        Engine engine =  (Integer fromFloor, Integer toFloor)  ->  {
            assertTrue(elevator.getState() == Elevator.State.GOINGUP);
        };
        elevator.setEngine(engine);
        this.elevator.pressButton(0,1);
    }

    @Test
    public void givenAnElevatorWhereEnginehasErrorThenIsInMaintenance() {
        elevator.errorEngine();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenDoorsHaveErrorThenIsInMaintenance() {
        elevator.errorCloseDoors();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }



    @Test
    public void givenAnElevatorWhenGoingUpThenReachFloor() {
        Engine engine =  (Integer fromFloor, Integer toFloor)  -> {
            assertTrue(toFloor==2);
        };
        elevator.setEngine(engine);

        this.elevator.pressButton(0,2);
        assertTrue(elevator.getState() == Elevator.State.WAITING);
    }

    @Test
    public void givenAnElevatorWhenPushButtonThenGoingDown() {
        Engine engine =  (Integer fromFloor, Integer toFloor)  -> {
            assertEquals(elevator.getState(),Elevator.State.GOINGDOWN);
        };

        this.elevator.pressButton(0,-1);

    }


    @Test
    public void givenAnElevatorWhenPushButtonAndHappensAnErrorThenIsStopped() {

        Engine engine =  (Integer fromFloor, Integer toFloor)  -> {
                if (fromFloor == 2 && toFloor == 3) {
                    elevator.errorEngine();
                }
        };

        elevator.setEngine(engine);
        elevator.pressButton(1,3);
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
        elevator.pressButton(2,4);
        assertTrue(elevator.getCurrentFloor() == 1);
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenPushMultipeButtonsThenReachAll() {
        this.elevator.pressButton(0,3);
        this.elevator.pressButton(2,4);

        Engine engine =  (Integer fromFloor, Integer toFloor)  -> {
            if (fromFloor == 3 && toFloor ==4) {
                assertTrue(elevator.getCurrentFloor() == 3);
            }
        };

        elevator.setEngine(engine);
        assertTrue(elevator.getCurrentFloor() == 4);


    }


    @Test
    public void givenAnBrokenElevatorWhenPushButtonThenNotReact() {
        this.elevator.errorEngine();
        this.elevator.pressButton(0,1);
        assertTrue(elevator.getCurrentFloor() == 0);
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }












}
