package logic.pieces;

import javafx.scene.image.ImageView;

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

    public void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }

    public abstract String getImageURL();
}
