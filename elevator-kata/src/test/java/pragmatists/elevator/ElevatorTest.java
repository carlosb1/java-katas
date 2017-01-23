package pragmatists.elevator;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ElevatorTest {

    private FakeDriverBoard driverBoard;
    private Elevator elevator;
    private Engine engine;
    @Before
    public void setUp () {
        engine = new Engine();
        elevator = new Elevator(engine);
        driverBoard = new FakeDriverBoard(elevator);
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
        this.driverBoard.pushButton(0,1);
        assertTrue(elevator.getState() == Elevator.State.GOINGUP);
    }

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












}
