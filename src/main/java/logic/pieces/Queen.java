package logic.pieces;

public class Queen extends Piece {
    public Queen(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wQ" : "bQ";
    }
}
