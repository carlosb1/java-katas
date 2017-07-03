import ferry.booking.model.ferry.PortLoader;
import ferry.booking.model.ferry.Port;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PortsTest {
    PortLoader portLoader;

    @Before
    public void setUp() {
        portLoader = new PortLoader();
    }

    @Test
    public void givenAPortsWhereISloadedThenIsOk () throws IOException {
        assertTrue(portLoader.load().size()  ==3);
    }

    @Test
    public void givenAPortWhereISLoadedThenValuesAreCorrect() throws IOException {
        List<Port> ports = portLoader.load();
        Port port = ports.get(0);
        assertPort(port,1,"Port Ellen");
        port = ports.get(1);
        assertPort(port,2,"Mos Eisley");
        port = ports.get(2);
        assertPort(port,3,"Tarsonis");

    }

    private void assertPort(Port port, int id, String name) {
        assertTrue(port.id == id);
        assertTrue(port.name.equals(name));
    }


}
