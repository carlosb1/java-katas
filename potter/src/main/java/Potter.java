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

    public Potter () {
        this.books = new ArrayList<>();
    }

    public static double DISCOUNTS_FOR_NUMBER_DIFFERENT_BOOKS[] = {1.,0.95,0.9,0.8,0.75};

    public double checkout() {

        if (!hasBooks()) {
            return 0;
        }

        double priceTotal = 0.;
        boolean exit = false;
        while (!exit) {
            int typeBooks = extractDiscountForNumTypesOfBooks();
            if (!hasMoreBooks(typeBooks)) {
                exit = true;
                continue;
            }
            priceTotal += calculatePrice(typeBooks);

        }

        return priceTotal;
    }

    private boolean hasMoreBooks(int typeBooks) {
        return typeBooks!=0;
    }

    private double calculatePrice(int typeBooks) {
        double price = typeBooks * 8.0;
        price *= DISCOUNTS_FOR_NUMBER_DIFFERENT_BOOKS[typeBooks - 1];
        return price;
    }

    private int extractDiscountForNumTypesOfBooks() {
        int typeBooks = 0;
        for (Book bookToCompare : Book.values()) {
            long numberBook = this.books.stream().filter(n -> n == bookToCompare).count();
            if (numberBook != 0) {
                typeBooks += 1;
                this.books.remove(bookToCompare);
            }
        }
        return typeBooks;
    }

    private boolean hasBooks() {
        long numberBooks = this.books.size();
        return numberBooks != 0;
    }


    public void add(Book book) {
        this.books.add(book);
    }
}
