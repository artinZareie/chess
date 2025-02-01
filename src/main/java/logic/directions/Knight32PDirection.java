package logic.directions;

public class Knight32PDirection extends Direction {
    public Knight32PDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight32PDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {3, 2};
    }
}
