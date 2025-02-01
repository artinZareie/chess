package logic.directions;

public class Knight23PDirection extends Direction {
    public Knight23PDirection(boolean isNegative) {
        super(isNegative);
    }

    public Knight23PDirection(boolean isNegative, int maxSteps) {
        super(isNegative, maxSteps);
    }

    @Override
    public int[] getDir() {
        return new int[] {2, 3};
    }
}
