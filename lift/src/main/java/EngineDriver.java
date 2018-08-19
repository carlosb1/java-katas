import java.util.Optional;

public class EngineDriver {
    private Optional<Lift> lift = Optional.empty();
    public void setUp(Lift lift) {
        this.lift = Optional.of(lift);
    }


}
