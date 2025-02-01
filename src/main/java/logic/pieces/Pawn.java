package logic.pieces;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wP" : "bP";
    }
}
