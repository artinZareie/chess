package logic.directions;

public class Knight12NDirection extends Direction {
    public Knight12NDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight12NDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, -2};
    }
}
