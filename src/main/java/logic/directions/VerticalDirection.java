package logic.directions;

public class VerticalDirection extends Direction {
    public VerticalDirection(boolean isNegative) {
        super(isNegative);
    }

    public VerticalDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {0, -1};
    }
}
