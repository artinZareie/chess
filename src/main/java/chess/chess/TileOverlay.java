package chess.chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.Engine;
import logic.Tile;

public class TileOverlay extends StackPane {
    private static final Color DEFAULT_COLOR = Color.color(0, 0, 1, 0.3);
    private final GameBoardApplication application;
    private static final int TILE_SIZE = 100;
    private final Rectangle overlay;
    private boolean isActive = false;
    private boolean isHighlighted = false;
    public final Tile tile;

    public TileOverlay(GameBoardApplication gameBoard, int x, int y) {
        this.application = gameBoard;
        this.tile = Engine.getInstance().getBoard().getTile(x, y);
        setPrefSize(TILE_SIZE, TILE_SIZE);
        overlay = new Rectangle(TILE_SIZE, TILE_SIZE);
        overlay.setFill(Color.TRANSPARENT);
        getChildren().add(overlay);

        setOnMouseClicked(event -> handleClick());
    }

    private void handleClick() {
        if (this.tile.hasPiece()) {
            application.deactivateAllTiles();

            if (!isActive) {
                activate();
                application.setActiveTile(this.tile);
            }
        }
    }

    public void activate() {
        isActive = true;
        overlay.setFill(DEFAULT_COLOR);
    }

    public void deactivate() {
        isActive = false;
        overlay.setFill(Color.TRANSPARENT);
    }

    public boolean isActive() {
        return isActive;
    }
}