package pragmatists.elevator;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ElevatorTest {

    private Elevator elevator;
    private FakeEngine engine;
    @Before
    public void setUp () {
        engine = new FakeEngine();
        elevator = new Elevator(engine);
        engine.setElevator(elevator);
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

        //TODO set engine
        this.elevator.pressButton(0,1);
        assertTrue(elevator.getState() == Elevator.State.GOINGUP);
    }
  /*
    @Test
    public void givenAnElevatorWhereEnginehasErrorThenIsInMaintenance() {
        this.driverBoard.throwsErrorEngine();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenDoorsHaveErrorThenIsInMaintenance() {
        this.driverBoard.throwsErrorDoor();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenGoingUpThenHappensErrorInEngine() {
        this.driverBoard.pushButton(0,1);
        this.driverBoard.throwsErrorEngine();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenGoingUpThenReachFloor() {
        this.driverBoard.pushButton(0,2);
 //       this.driverBoard.reachFloor(2);
        assertTrue(elevator.getState() == Elevator.State.WAITING);
    }

    @Test
    public void givenAnElevatorWhenPushButtonThenGoingDown() {
        this.driverBoard.pushButton(0,-1);
        assertTrue(elevator.getState() == Elevator.State.GOINGDOWN);
    }

    @Test
    public void givenAnElevatorWhenPushButtonAndHappensAnErrorThenIsStopped() {
        this.driverBoard.pushButton(1,3);
        //     this.driverBoard.reachFloor(2);
        this.driverBoard.throwsErrorEngine();
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
        //    this.driverBoard.reachFloor(3);
        assertTrue(elevator.getCurrentFloor() == 2);
        assertTrue(elevator.getState() == Elevator.State.MAINTENANCE);
    }

    @Test
    public void givenAnElevatorWhenPushMultipeButtonsThenReachAll() {
        this.driverBoard.pushButton(0,3);
        this.driverBoard.pushButton(2,4);
        //     this.driverBoard.reachFloor(1);
//        this.driverBoard.reachFloor(3);
        assertTrue(elevator.getCurrentFloor() == 3);
        //     this.driverBoard.reachFloor(4);
        assertTrue(elevator.getCurrentFloor() == 4);


    }
    @Test
    public void givenAnBrokenElevatorWhenPushButtonThenNotReact() {
        this.driverBoard.throwsErrorEngine();
        this.driverBoard.pushButton(0,1);
        assertTrue(elevator.getCurrentFloor() == 0);
    }
*/











}
