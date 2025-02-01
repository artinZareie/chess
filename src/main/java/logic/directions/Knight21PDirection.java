package logic.directions;

public class Knight21PDirection extends Direction {
    public Knight21PDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight21PDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {2, 1};
    }
}
