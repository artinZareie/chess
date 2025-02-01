package logic.pieces;

public class Rook extends Piece {
    public Rook(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wR" : "bR";
    }
}
