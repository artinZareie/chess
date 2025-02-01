package logic.directions;

public class Knight21NDirection extends Direction {
    public Knight21NDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight21NDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {2, -1};
    }
}
