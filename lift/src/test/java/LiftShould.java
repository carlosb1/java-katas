import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LiftShould
{
    Lift lift;
    @Before
    public void setUp() {
        lift = new Lift(0);

    }
    @Test
    public void  be_initialized_correctly()
    {
        Assert.assertEquals(0,lift.getCurrentFloor());
    }
    @Test
    public void go_to_pushed_button_floor() {
        lift = new Lift(0);
        lift.pusbButton(1);
        Assert.assertEquals(1, lift.getCurrentFloor());

    }
}
