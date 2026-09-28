package cleancode;

public class CapacityReachedException extends RuntimeException {
    public CapacityReachedException() {
        super("Not enough places available on that day!");
    }
}
