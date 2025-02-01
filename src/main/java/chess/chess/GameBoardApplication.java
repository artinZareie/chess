package chess.chess;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Board;
import logic.Engine;
import logic.Tile;
import logic.pieces.Piece;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class GameBoardApplication extends GameApplication {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 850;
    private static final int TILE_SIZE = 100;
    private static final String TITLE = "Stupid chess game";
    private final TileOverlay[][] tileOverlays = new TileOverlay[8][8];
    private Tile activeTile = null;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(WIDTH);
        settings.setHeight(HEIGHT);
        settings.setTitle(TITLE);
    }

    @Override
    protected void initGame() {
        ImageView bg = FXGL.getAssetLoader().loadTexture("blue-marble.jpg");
        bg.setFitWidth(WIDTH);
        bg.setFitHeight(WIDTH);

        FXGL.getGameScene().addUINode(bg);

        // Create a background for the texts.
        Rectangle textBackground = new Rectangle(WIDTH, 50);
        textBackground.setFill(Color.DARKCYAN);
        textBackground.setTranslateY(800);

        // Add player names and remaining time with custom styles.
        StackPane player1Pane = createPlayerPane(Engine.getInstance().whitePlayer.getName() + ": " +
                formatDuration(Engine.getInstance().whitePlayer.getRemainingTime()), Color.DARKBLUE, Color.DARKCYAN);
        player1Pane.setTranslateX(10);
        player1Pane.setTranslateY(820);

        StackPane player2Pane = createPlayerPane(Engine.getInstance().blackPlayer.getName() + ": " +
                formatDuration(Engine.getInstance().blackPlayer.getRemainingTime()), Color.BLACK, Color.DARKCYAN);
        player2Pane.setTranslateX(410);
        player2Pane.setTranslateY(820);

        FXGL.getGameScene().addUINode(textBackground);
        FXGL.getGameScene().addUINode(player1Pane);
        FXGL.getGameScene().addUINode(player2Pane);

        GridPane board = new GridPane();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                TileOverlay tileOverlay = new TileOverlay(this, x, y);
                tileOverlays[x][y] = tileOverlay;
                board.add(tileOverlay, x, y);
            }
        }

        FXGL.getGameScene().addUINode(board);

        // Draw pieces based on the current state of the board.
        Board gameBoard = Engine.getInstance().getBoard();
        for (Piece piece : gameBoard.getPieces()) {
            int[] position = piece.getPosition();
            piece.imageView = placePiece(piece.getImageURL(), position[0], position[1]);
        }
    }

    private String formatDuration(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        return String.format("%02d:%02d", minutes, seconds);
    }

    private StackPane createPlayerPane(String text, Color textColor, Color bgColor) {
        Text playerText = new Text(text);
        playerText.setFont(new Font("Comic Sans MS", 20));
        playerText.setFill(textColor);

        Rectangle bg = new Rectangle(200, 30);
        bg.setFill(bgColor);

        StackPane pane = new StackPane();
        pane.getChildren().addAll(bg, playerText);
        return pane;
    }

    @NotNull
    private ImageView placePiece(String piece, int x, int y) {
        ImageView pieceView = FXGL.getAssetLoader().loadTexture(piece + ".png");

        pieceView.setFitWidth(TILE_SIZE);
        pieceView.setFitHeight(TILE_SIZE);

        pieceView.setTranslateX(x * TILE_SIZE);
        pieceView.setTranslateY(y * TILE_SIZE);

        FXGL.getGameScene().addUINode(pieceView);

        return pieceView;
    }

    public void deactivateAllTiles() {
        for (TileOverlay[] row : tileOverlays) {
            for (TileOverlay tileOverlay : row) {
                tileOverlay.deactivate();
            }
        }

        activeTile = null;
    }

    public void setActiveTile(Tile tile) {
        activeTile = tile;
    }

    public static void main(String[] args) {
        launch(args);
    }
}