package logic.pieces;

import javafx.scene.image.ImageView;
import logic.Move;
import logic.directions.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    protected final boolean isWhite;
    protected int[] position;
    public ImageView imageView;

    public Piece(boolean isWhite, int x, int y) {
        this.isWhite = isWhite;
        this.position = new int[]{x, y};
    }

    public boolean isWhite() {
        return isWhite;
    }

    public int[] getPosition() {
        return position;
    }

    private void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
        updateImageViewPosition();
    }

    private void updateImageViewPosition() {
        if (imageView != null) {
            imageView.setTranslateX(position[0] * 100);
            imageView.setTranslateY((7 - position[1]) * 100);
        }
    }

    public abstract String getImageURL();
    public abstract List<Direction> getDirections();

    public void move(Move move) {
        setPosition(move.getToX(), move.getToY());
    }

    public List<Move> getAllAvailableMoves() {
        List<Move> allMoves = new ArrayList<>();
        for (Direction direction : getDirections()) {
            allMoves.addAll(direction.getMoves(getPosition()));
        }

        return allMoves;
    }
}
