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

    public Potter () {
        this.books = new ArrayList();
    }

    public double checkout() {
        long numberBooks = this.books.size();

        long books1 = this.books.stream().filter(n -> n == Book.BOOK1).count();
        long books2 = this.books.stream().filter(n -> n == Book.BOOK2).count();

        return numberBooks*8.0;
    }

    public void add(Book book) {

        this.books.add(book);
    }
}
