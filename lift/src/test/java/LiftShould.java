import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class LiftShould
{
    @Test
    public void  be_initialized_correctly()
    {
        Lift lift = new Lift(0);
        Assert.assertEquals(0,lift.getFloor());
    }
    @Test
    public void go_to_pushed_button_floor() {
        //TODO lift set up in setUp
        Lift lift = new Lift(0);
        lift.pusbButton(1);
        Assert.assertEquals(1, lift.getFloor());

    }
}
