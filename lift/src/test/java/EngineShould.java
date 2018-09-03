import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EngineShould {

    EngineDriver engineDriver;
    @Before
    public void setUp() {
        engineDriver = new EngineDriver();
    }
    @Test
    public void  be_notify_operation_correctly()
    {
        engineDriver.onArrive(1);
        Assert.assertEquals(1, engineDriver.getCurrentFloor());
    }

    @Test
    public void be_notify_is_moving_engine() {
        engineDriver.onStatus(EngineDriver.Status.MOVING);
        Assert.assertEquals(EngineDriver.Status.MOVING, engineDriver.getStatus());
    }
}
