package logic.directions;

import logic.Engine;
import logic.Move;

public abstract class Direction {
    public int maxSteps = 8;
    protected final boolean negativeSteps;

    public Direction(boolean negativeSteps) {
        this.negativeSteps = negativeSteps;
    }

    public Direction(boolean negativeSteps, int maxSteps) {
        this.negativeSteps = negativeSteps;
        this.maxSteps = maxSteps;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public boolean isNegative() {
        return negativeSteps;
    }

    public int[] getDiff(int step) {
        int[] dir = getDir();
        dir = new int[] {dir[0] * step, dir[1] * step};

        if (isNegative()) {
            dir = new int[] {dir[0] * -1, dir[1] * -1};
        }

        return dir;
    }

    public int[] getDiff() {
        return getDiff(1);
    }

    public int[] getPos(int[] start) {
        int[] diff = getDiff();
        return new int[] {start[0] + diff[0], start[1] + diff[1]};
    }

    public int[] getPos(int[] start, int step) {
        int[] diff = getDiff(step);
        return new int[] {start[0] + diff[0], start[1] + diff[1]};
    }

    public Move getMove(int[] start) {
        return new Move(Engine.getInstance().getBoard().getTile(start),
                Engine.getInstance().getBoard().getTile(getPos(start)));
    }

    public Move getMove(int[] start, int step) {
        return new Move(Engine.getInstance().getBoard().getTile(start),
                Engine.getInstance().getBoard().getTile(getPos(start, step)));
    }

    public abstract int[] getDir();
}
