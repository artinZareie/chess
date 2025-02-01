package logic.directions;

public class HorizontalDirection extends Direction {
    @Override
    public int[] getDir() {
        return new int[] {1, 0};
    }
}
