package chess.chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileOverlay extends StackPane {
    private final GameBoardApplication application;
    private static final int TILE_SIZE = 100;
    private final Rectangle overlay;
    private boolean isActive;

    public TileOverlay(GameBoardApplication gameBoard) {
        this.application = gameBoard;
        setPrefSize(TILE_SIZE, TILE_SIZE);
        overlay = new Rectangle(TILE_SIZE, TILE_SIZE);
        overlay.setFill(Color.TRANSPARENT);
        getChildren().add(overlay);

        setOnMouseClicked(event -> handleClick());
    }

    private void handleClick() {
        application.deactivateAllTiles();

        if (!isActive) {
            activate();
        }
    }

    public void activate() {
        isActive = true;
        overlay.setFill(Color.color(0, 0, 1, 0.3));
    }

    public void deactivate() {
        isActive = false;
        overlay.setFill(Color.TRANSPARENT);
    }

    public boolean isActive() {
        return isActive;
    }
}