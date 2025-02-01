package logic.pieces;

public class Knight extends Piece {
    public Knight(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wN" : "bN";
    }
}
