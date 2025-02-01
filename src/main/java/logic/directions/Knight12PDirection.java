package logic.directions;

public class Knight12PDirection extends Direction {
    public Knight12PDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight12PDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {1, 2};
    }
}
