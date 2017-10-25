import java.util.ArrayList;

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
    private boolean differentBook;

    public Potter () {
        this.differentBook = false;
        this.books = new ArrayList<Potter.Book>();
    }

    public double checkout() {
        long numberBooks = this.books.size();
        double price = numberBooks*8.0;

        //TODO try to implement without this index
        int index = 0;

        for (Book book: this.books )  {
            if (index == this.books.size()-1) {
                break;
            }
            differentBook = !this.books.subList(index+1,this.books.size()).contains(book);
            index++;

            if (differentBook) {
                break;
            }
        }

        //long books1 = this.books.stream().filter(n -> n == Book.BOOK1).count();
        //long books2 = this.books.stream().filter(n -> n == Book.BOOK2).count();
        if (differentBook) {
            price = price * 0.95;
        }

        return price;
    }

    public void add(Book book) {
        this.books.add(book);
    }
}
