package logic.pieces;
import logic.directions.Direction;
import logic.directions.HorizontalDirection;
import logic.directions.VerticalDirection;

import java.util.List;

public class Rook extends Piece {
    public Rook(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wR" : "bR";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(
                new VerticalDirection(true, 8),
                new VerticalDirection(false, 8),
                new HorizontalDirection(true, 8),
                new HorizontalDirection(false, 8)
        );
    }
}
