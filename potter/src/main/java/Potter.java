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

    public static double ARRAY_DISCOUNTS  [] = {1.,0.95,0.9,0.8};
    public double checkout() {
        double price = 0.;
        long numberBooks = this.books.size();

        if (numberBooks == 0 ) {
            return price;
        }

        int typeBooks =0;
        for (Potter.Book bookToCompare: Potter.Book.values())  {
            long numberBook = this.books.stream().filter(n-> n == bookToCompare).count();
            if (numberBook!=0) {
                typeBooks+=1;
            }
        }
        price = numberBooks*8.0;
        price *= ARRAY_DISCOUNTS[typeBooks-1];



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
