package logic.pieces;

import logic.Board;
import logic.Engine;
import logic.Move;
import logic.directions.Direction;
import logic.directions.VerticalDirection;
import logic.directions.MainDiagDirection;
import logic.directions.SecondaryDiagDirection;
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
        List<Direction> directions = new ArrayList<>();
        Board board = Engine.getInstance().getBoard();
        int direction = isWhite ? 1 : -1;
        int startRow = isWhite ? 1 : 6;
        int x = position[0];
        int y = position[1];

        if (board.isEmpty(x, y + direction)) {
            directions.add(new VerticalDirection(isWhite, 1));
            if (!hasMoved && board.isEmpty(x, y + 2 * direction)) {
                directions.add(new VerticalDirection(isWhite, 2));
            }
        }

        if (!isWhite) {
            if (board.isValidCoord(new int[]{x + 1, y + direction}) && !board.isEmpty(x + 1, y + direction)) {
                directions.add(new MainDiagDirection(isWhite, 1));
            }

            if (board.isValidCoord(new int[]{x - 1, y + direction}) && !board.isEmpty(x - 1, y + direction)) {
                directions.add(new SecondaryDiagDirection(isWhite, 1));
            }
        } else {
            if (board.isValidCoord(new int[]{x - 1, y + direction}) && !board.isEmpty(x - 1, y + direction)) {
                directions.add(new MainDiagDirection(isWhite, 1));
            }

            if (board.isValidCoord(new int[]{x + 1, y + direction}) && !board.isEmpty(x + 1, y + direction)) {
                directions.add(new SecondaryDiagDirection(isWhite, 1));
            }
        }

        return directions;
    }

    @Override
    public void move(Move move) {
        super.move(move);
        hasMoved = true;
    }
}