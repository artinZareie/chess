package logic.pieces;

import logic.directions.Direction;
import logic.directions.Knight12NDirection;
import logic.directions.Knight12PDirection;
import logic.directions.Knight21NDirection;
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
                new Knight12NDirection(true, 1),
                new Knight12NDirection(false, 1),
                new Knight12PDirection(true, 1),
                new Knight12PDirection(false, 1),
                new Knight21NDirection(true, 1),
                new Knight21NDirection(false, 1),
                new Knight12PDirection(true, 1),
                new Knight12PDirection(false, 1)
        );
    }
}
