package logic.directions;

public class MainDiagDirection extends Direction {
    @Override
    public int[] getDir() {
        return new int[] {1, -1};
    }
}
