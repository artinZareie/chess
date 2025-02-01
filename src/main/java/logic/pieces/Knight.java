package logic.pieces;

import logic.directions.Direction;
import logic.directions.Knight23NDirection;
import logic.directions.Knight23PDirection;
import logic.directions.Knight32NDirection;
import java.util.List;

public class Knight extends Piece {
    public Knight(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wN" : "bN";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(
                new Knight23NDirection(true, 1),
                new Knight23NDirection(false, 1),
                new Knight23PDirection(true, 1),
                new Knight23PDirection(false, 1),
                new Knight32NDirection(true, 1),
                new Knight32NDirection(false, 1),
                new Knight23PDirection(true, 1),
                new Knight23PDirection(false, 1)
        );
    }
}
