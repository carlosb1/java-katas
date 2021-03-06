
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
    public void should_add_three_different_books_not_consecutives_with_discount () {
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK3);
        potter.add (Potter.Book.BOOK5);
        double price = potter.checkout();
        Assert.assertEquals(21.6,price,0.0001f);
    }

    @Test
    public void should_add_four_different_books_with_discount () {
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        potter.add (Potter.Book.BOOK3);
        potter.add (Potter.Book.BOOK4);
        double price = potter.checkout();
        Assert.assertEquals(25.6,price,0.0001f);
    }
    @Test
    public void should_add_five_different_books_with_discount () {
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        potter.add (Potter.Book.BOOK3);
        potter.add (Potter.Book.BOOK4);
        potter.add (Potter.Book.BOOK5);
        double price = potter.checkout();
        Assert.assertEquals(30.0,price,0.0001f);
    }


    @Test
<<<<<<< HEAD
    public void should_add_two_same_books_and_two_differents ()  {
        potter.add(Potter.Book.BOOK1);
        potter.add(Potter.Book.BOOK1);
        potter.add(Potter.Book.BOOK2);
        potter.add(Potter.Book.BOOK3);

        double price = potter.checkout();
        Assert.assertEquals(31.2, price,0.0001);
    }

=======
    public void should_add_two_different_books_two_times_with_discount () {
        /* 15.2 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        /* 15.2 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        double price = potter.checkout();
        Assert.assertEquals(30.4,price,0.0001f);
    }

    @Test
    public void should_add_two_different_type_of_discounts () {
        /* 21.6 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        potter.add (Potter.Book.BOOK3);

        /* 15.2 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        double price = potter.checkout();
        Assert.assertEquals(36.8,price,0.0001f);
    }


    @Test
    public void should_add_a_different_type_of_discounts () {
        /* 21.6 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK2);
        potter.add (Potter.Book.BOOK3);

        /* 16.0 */
        potter.add (Potter.Book.BOOK1);
        potter.add (Potter.Book.BOOK1);
        double price = potter.checkout();
        Assert.assertEquals(37.6,price,0.0001f);
    }


>>>>>>> 9e467bcbb0ed34cba9f3108dbf868076b9d4d8f8

}
