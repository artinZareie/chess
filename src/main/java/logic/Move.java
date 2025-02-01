package logic;

public class Move {
    private final Tile from;
    private final Tile to;

    public Move(Tile from, Tile to) {
        this.from = from;
        this.to = to;
    }

    public Tile getFrom() {
        return from;
    }

    public Tile getTo() {
        return to;
    }

    public int getFromX() {
        return from.getX();
    }

    public int getFromY() {
        return from.getY();
    }

    public int getToX() {
        return to.getX();
    }

    public int getToY() {
        return to.getY();
    }
}
