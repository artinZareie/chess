package logic.pieces;

import logic.Move;
import logic.directions.Direction;
import logic.directions.VerticalDirection;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wP" : "bP";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(new VerticalDirection(isWhite, hasMoved ? 1 : 2));
    }

    @Override
    public void move(Move move) {
        super.move(move);
        hasMoved = true;
    }
}
