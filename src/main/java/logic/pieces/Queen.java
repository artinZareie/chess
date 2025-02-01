package logic.pieces;

import logic.directions.*;

import java.util.List;

public class Queen extends Piece {
    public Queen(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wQ" : "bQ";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(
                new VerticalDirection(true, 8),
                new VerticalDirection(false, 8),
                new HorizontalDirection(true, 8),
                new HorizontalDirection(false, 8),
                new MainDiagDirection(true, 8),
                new MainDiagDirection(false, 8),
                new SecondaryDiagDirection(true,8),
                new SecondaryDiagDirection(false,8)
        );
    }
}
