import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
=======
>>>>>>> 9e467bcbb0ed34cba9f3108dbf868076b9d4d8f8

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

<<<<<<< HEAD
        int typeBooks =0;
        for (Potter.Book bookToCompare: Potter.Book.values())  {
            long numberBook = this.books.stream().filter(n-> n == bookToCompare).count();
            if (numberBook!=0) {
                //TODO move to list
                int [] indexes = IntStream.range(0,this.books.size()).filter(index -> this.books.get(index) == bookToCompare).toArray();
                for (int index: indexes) {
                }
//                this.books.stream().filter(n-> n == bookToCompare).
                typeBooks+=1;
=======
        double priceTotal = 0.;
        boolean exit = false;
        while (!exit) {
            int typeBooks = extractDiscountForNumTypesOfBooks();
            if (!hasMoreBooks(typeBooks)) {
                exit = true;
                continue;
>>>>>>> 9e467bcbb0ed34cba9f3108dbf868076b9d4d8f8
            }
            priceTotal += calculatePrice(typeBooks);

        }

<<<<<<< HEAD
        return price;
    }

    //TODO move all code to checkout
=======
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


>>>>>>> 9e467bcbb0ed34cba9f3108dbf868076b9d4d8f8
    public void add(Book book) {
        this.books.add(book);
    }
}
