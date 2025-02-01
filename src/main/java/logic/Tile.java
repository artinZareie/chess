package logic;

import logic.pieces.Piece;

public class Tile {
    private final int x;
    private final int y;
    private final boolean isWhite;
    private Piece piece = null;

    public Tile(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
