public class Potter {
    public enum Books {
        BOOK1,
        BOOK2,
        BOOK3,
        BOOK4,
        BOOK5
    };


    private float price;

    public Potter () {
        this.price = 0.f;

    }

    public float checkout() {
        return this.price;
    }

    public void add(Books book1) {

        this.price += 8.0f;
    }
}
