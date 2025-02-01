package logic.directions;

public class Knight23NDirection extends Direction {
    public Knight23NDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight23NDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {2, -3};
    }
}
