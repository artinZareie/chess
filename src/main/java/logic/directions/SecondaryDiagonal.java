package logic.directions;

public class SecondaryDiagonal extends Direction {
    public SecondaryDiagonal(boolean isNegative) {
        super(isNegative);
    }

    public SecondaryDiagonal(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, 1};
    }
}
