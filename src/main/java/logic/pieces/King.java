package logic.pieces;

import logic.directions.*;

import java.util.List;

public class King extends Piece {
    public King(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public String getImageURL() {
        return isWhite ? "wK" : "bK";
    }

    @Override
    public List<Direction> getDirections() {
        return List.of(
            new VerticalDirection(true, 1),
            new VerticalDirection(false, 1),
            new HorizontalDirection(true, 1),
            new HorizontalDirection(false, 1),
            new MainDiagDirection(true, 1),
            new MainDiagDirection(false, 1),
            new SecondaryDiagDirection(true,1),
            new SecondaryDiagDirection(false,1)
        );
    }
}
