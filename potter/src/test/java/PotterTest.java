
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
            double price = potter.checkout();
            Assert.assertEquals(0.f,price,0.01);
    }

    @Test
    public void should_be_add_one_book () {
        potter.add(Potter.Book.BOOK1);
        double price = potter.checkout();
        Assert.assertEquals(8,price,0.01);
    }

    @Test
    public void should_add_two_books ()  {
        potter.add(Potter.Book.BOOK1);
        potter.add(Potter.Book.BOOK1);
        double price = potter.checkout();
        Assert.assertEquals(16.0, price,0.01);
    }

    @Test
    public void should_add_two_different_books_with_discount () {
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        double price = potter.checkout();
        Assert.assertEquals(15.2,price,0.0001f);
    }

    @Test
    public void should_add_three_different_books_with_discount () {
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        potter.add (Potter.Book.BOOK3);
        double price = potter.checkout();
        Assert.assertEquals(21.6,price,0.0001f);
    }


}
