package models;

public class Cellula {
    enum State {Live, Dead};
    public  State state;
    public final Integer x;
    public final Integer y;
    public Cellula(final Integer x, final Integer y) {
        this.x = x;
        this.y = y;
        this.state = State.Live;
    }
    public Cellula(final Integer x, final Integer y, State state) {
            this.x = x;
            this.y = y;
            this.state = state;
    }

}
