
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class PotterTest {

    Potter potter;

    @Before
    public void setUp () {
        potter = new Potter();
    }

    @Test
    public void should_be_initialised_empty() {
            float price = potter.checkout();
            Assert.assertEquals(0.f,price,0.01);
    }

    @Test
    public void should_be_add_one_book () {
        potter.add("book1");
        float price = potter.checkout();
        Assert.assertEquals(8,price,0.01);
    }

    @Test
    public void should_add_two_books ()  {
        potter.add("book1");
        potter.add("book1");
        float price = potter.checkout();
        Assert.assertEquals(16.0, price,0.01);
    }


}
