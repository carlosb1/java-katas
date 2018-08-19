import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LiftShould
{



    Lift lift;
    @Before
    public void setUp() {
        lift = new Lift(0, new EngineDriver());
    }
    @Test
    public void  be_initialized_correctly()
    {
        Assert.assertEquals(0,lift.getCurrentFloor());
    }

    @Test
    public void go_to_pushed_button_floor() {
        lift.pushButton(1);
        Assert.assertEquals(1, lift.getCurrentFloor());
    }
    @Test
    public void describe_action_when_moves() {
        lift.pushButton(1);
        Action  action = lift.getAction();
        Assert.assertEquals(Action.Up,action);
    }

    @Test
    public void checks_lift_arrive_correctly() {
        EngineDriver engineDriver = new EngineDriver();
        lift = new Lift(0,engineDriver);
        lift.pushButton(1);
        Action  action = lift.getAction();

    }

}

