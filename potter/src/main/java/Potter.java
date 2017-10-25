import java.util.ArrayList;

public class Potter {

    public enum Book {
        BOOK1,
        BOOK2,
        BOOK3,
        BOOK4,
        BOOK5
    };

    private final ArrayList books;
    private float price;
    private boolean differentBook;

    public Potter () {
        this.differentBook = false;
        this.books = new ArrayList();
    }

    public double checkout() {
        long numberBooks = this.books.size();
        double price = numberBooks*8.0;

        //long books1 = this.books.stream().filter(n -> n == Book.BOOK1).count();
        //long books2 = this.books.stream().filter(n -> n == Book.BOOK2).count();
        if (differentBook) {
            price = price * 0.95;
        }

        return price;
    }

    public void add(Book book) {

        if (this.books.size() != 0) {
            this.differentBook = !this.books.contains(book);
        }

        this.books.add(book);
    }
}
