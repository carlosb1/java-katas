
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotterTest {

    Potter potter;

    @Test
    public void should_be_initialised_empty() {
            potter = new Potter();

            float price = potter.checkout();
            assertEquals(0.f,price);
    }

    @Test
    public void should_be_add_one_book () {
        //TODO add setup
        potter = new Potter();

        potter.add("book1");
        float price = potter.checkout();
    }
}
