import junit.framework.TestCase;
import org.junit.Assert;
public class LiftTest
        extends TestCase
{


    public void test_should_be_initialized_correctly()
    {
        Lift lift = new Lift();
        Assert.assertEquals(0,lift.getFloor());

    }
}
