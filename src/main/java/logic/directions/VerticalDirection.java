package logic.directions;

public class VerticalDirection extends Direction {
    @Override
    public int[] getDir() {
        return new int[] {0, -1};
    }
}
