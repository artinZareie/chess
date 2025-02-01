package logic.directions;

public class HorizontalDirection extends Direction {
    public HorizontalDirection(boolean isNegative) {
        super(isNegative);
    }

    public HorizontalDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, 0};
    }
}
