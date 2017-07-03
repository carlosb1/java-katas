import ferry.booking.model.ferry.Ferry;
import ferry.booking.model.ferry.FerryLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by carlos on 4/13/17.
 */
public class FerriesTest {
    private FerryLoader loader;


    @Before
    public void setUp() {
        loader = new FerryLoader();
    }
    @Test
    public void givenFerriesTestThenReturnAList () throws IOException {
       assertTrue(loader.load().size()==10);
    }

    public void assertExistFerry(Ferry ferry, int id, String name, int passengers, int vehicles, int weight, int homePortId) {
        assertTrue(ferry.id == id);
        assertTrue(ferry.name.equals(name));
        assertTrue(ferry.passengers== passengers);
        assertTrue(ferry.vehicles == vehicles);
        assertTrue(ferry.weight==weight);
        assertTrue(ferry.homePortId == homePortId);

    }

    @Test
    public void givenFerriesWhereIsInitializedThenLoadCorrectly() throws IOException {
        List<Ferry> ferry = loader.load();
        assertExistFerry(ferry.get(0),1,"Titanic",12,8,10,1);
        assertExistFerry(ferry.get(1),2,"Hyperion",16,10,12,1);

        assertExistFerry(ferry.get(2),3,"Millenium Falcon",8,2,1,1);
        assertExistFerry(ferry.get(3),4,"Golden Hind",14,4,3,1);

        assertExistFerry(ferry.get(4),5,"Enterprise",14,12,14,2);
        assertExistFerry(ferry.get(5),6,"Hood",8,4,4,1);

        assertExistFerry(ferry.get(6),7,"Tempest",8,2,1,2);
        assertExistFerry(ferry.get(7),8,"Dreadnaught",25,10,25,3);

        assertExistFerry(ferry.get(8),9,"Defiant",11,3,3,3);
        assertExistFerry(ferry.get(9),10,"Black Pearl",12,4,5,2);


    }

}