package logic.pieces;

public class King extends Piece {
    public King(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wK" : "bK";
    }
}
