package logic.directions;

public class Knight32NDirection extends Direction {
    public Knight32NDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight32NDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {3, -2};
    }
}
