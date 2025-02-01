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
}
