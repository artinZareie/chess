package logic.pieces;

import logic.directions.Direction;
import logic.directions.MainDiagDirection;
import logic.directions.SecondaryDiagDirection;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wB" : "bB";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(
                new MainDiagDirection(true),
                new MainDiagDirection(false),
                new SecondaryDiagDirection(true),
                new SecondaryDiagDirection(false)
        );
    }
}
