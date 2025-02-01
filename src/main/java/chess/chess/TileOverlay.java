package chess.chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.Engine;
import logic.Move;
import logic.Tile;
import logic.pieces.Piece;

import java.util.List;

public class TileOverlay extends StackPane {
    private static final Color DEFAULT_COLOR = Color.color(0, 0, 1, 0.3);
    private static final Color HIGHLIGHT_COLOR = Color.color(1, 0.75, 0.8, 0.4);
    private final GameBoardApplication application;
    private static final int TILE_SIZE = 100;
    private final Rectangle overlay;
    private boolean isActive = false;
    private boolean isHighlighted = false;
    public final Tile tile;

    public TileOverlay(GameBoardApplication gameBoard, int x, int y) {
        this.application = gameBoard;
        this.tile = Engine.getInstance().getBoard().getTile(x, 7 - y);
        setPrefSize(TILE_SIZE, TILE_SIZE);
        overlay = new Rectangle(TILE_SIZE, TILE_SIZE);
        overlay.setFill(Color.TRANSPARENT);
        getChildren().add(overlay);

        setOnMouseClicked(event -> handleClick());
    }

    private void handleClick() {
        System.out.println("Tile clicked: " + tile.getX() + ", " + tile.getY());
        System.out.println("Piece: " + tile.getPiece());

        if (isHighlighted) {
            Tile activeTile = application.getActiveTile();
            application.deactivateAllTiles();

            if (activeTile != null) {
                Move move = new Move(activeTile, this.tile);
                Engine.getInstance().getBoard().move(move);
            }
        } else if (this.tile.hasPiece()) {
            Piece piece = this.tile.getPiece();
            boolean isWhiteTurn = Engine.getInstance().isWhiteTurn;
            if (isActive) {
                application.deactivateAllTiles();
            } else if (isWhiteTurn == piece.isWhite()) {
                application.deactivateAllTiles();
                activate();
                application.setActiveTile(this.tile);
                highlightReachableTiles();
            }
        }
    }

    public void activate() {
        isActive = true;
        isHighlighted = false;
        overlay.setFill(DEFAULT_COLOR);
    }

    public void deactivate() {
        isActive = false;
        isHighlighted = false;
        overlay.setFill(Color.TRANSPARENT);
    }

    public void highlight() {
        if (!isActive) {
            isHighlighted = true;
            overlay.setFill(HIGHLIGHT_COLOR);
        }
    }

    public void removeHighlight() {
        isHighlighted = false;
        overlay.setFill(Color.TRANSPARENT);
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    private void highlightReachableTiles() {
        Piece piece = tile.getPiece();
        List<Move> moves = piece.getAllAvailableMoves();
        for (Move move : moves) {
            Tile pos = move.getTo();
            TileOverlay targetTileOverlay = application.tileOverlays[7 - pos.getY()][pos.getX()];
            targetTileOverlay.highlight();
        }
    }
}