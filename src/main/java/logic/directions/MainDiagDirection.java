package logic.directions;

public class MainDiagDirection extends Direction {
    public MainDiagDirection(boolean isNegative) {
        super(isNegative);
    }

    public MainDiagDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, -1};
    }
}
