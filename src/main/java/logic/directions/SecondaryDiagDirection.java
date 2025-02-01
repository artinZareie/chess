package logic.directions;

public class SecondaryDiagDirection extends Direction {
    public SecondaryDiagDirection(boolean isNegative) {
        super(isNegative);
    }

    public SecondaryDiagDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, 1};
    }
}
