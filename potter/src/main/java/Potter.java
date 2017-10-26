import java.util.ArrayList;
import java.util.Arrays;

public class Potter {

    public enum Book {
        BOOK1,
        BOOK2,
        BOOK3,
        BOOK4,
        BOOK5
    };

    private final ArrayList<Potter.Book> books;
    private float price;


    public Potter () {
        this.books = new ArrayList<Potter.Book>();
    }

    public double checkout() {
        double price = 0.;
        long book1s = this.books.stream().filter(n-> n == Book.BOOK1).count();
        if (book1s !=0) {
            long numberBooks = this.books.size();
            price = numberBooks*8.0;
        }
        long book2s = this.books.stream().filter(n -> n == Book.BOOK2).count();
        if (book2s != 0 && book1s != 0) {
            long numberBooks = this.books.size();
            price = numberBooks*8.0;
            price *= 0.95;
        }

        return price;
    }

    private boolean isLastElement(int index) {
        if (index == this.books.size()-1) {
            return true;
        }
        return false;
    }

    public void add(Book book) {
        this.books.add(book);
    }
}
