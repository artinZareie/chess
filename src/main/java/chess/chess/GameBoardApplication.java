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

public class GameBoardApplication extends GameApplication {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 850;
    private static final int TILE_SIZE = 100;
    private static final String TITLE = "Stupid chess game";
    private final TileOverlay[][] tileOverlays = new TileOverlay[8][8];

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
        StackPane player1Pane = createPlayerPane("Player 1: 10:00", Color.DARKBLUE, Color.DARKCYAN);
        player1Pane.setTranslateX(10);
        player1Pane.setTranslateY(820);

        StackPane player2Pane = createPlayerPane("Player 2: 10:00", Color.BLACK, Color.DARKCYAN);
        player2Pane.setTranslateX(410);
        player2Pane.setTranslateY(820);

        FXGL.getGameScene().addUINode(textBackground);
        FXGL.getGameScene().addUINode(player1Pane);
        FXGL.getGameScene().addUINode(player2Pane);

        GridPane board = new GridPane();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                TileOverlay tileOverlay = new TileOverlay(this);
                tileOverlays[x][y] = tileOverlay;
                board.add(tileOverlay, x, y);
            }
        }

        FXGL.getGameScene().addUINode(board);

        // Create the initial board.
        placePiece("wR", 0, 0);
        placePiece("wN", 1, 0);
        placePiece("wB", 2, 0);
        placePiece("wQ", 3, 0);
        placePiece("wK", 4, 0);
        placePiece("wB", 5, 0);
        placePiece("wN", 6, 0);
        placePiece("wR", 7, 0);
        for (int i = 0; i < 8; i++) {
            placePiece("wP", i, 1);
        }

        placePiece("bR", 0, 7);
        placePiece("bN", 1, 7);
        placePiece("bB", 2, 7);
        placePiece("bQ", 3, 7);
        placePiece("bK", 4, 7);
        placePiece("bB", 5, 7);
        placePiece("bN", 6, 7);
        placePiece("bR", 7, 7);
        for (int i = 0; i < 8; i++) {
            placePiece("bP", i, 6);
        }
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

    private void placePiece(String piece, int x, int y) {
        ImageView pieceView = FXGL.getAssetLoader().loadTexture(piece + ".png");

        pieceView.setFitWidth(TILE_SIZE);
        pieceView.setFitHeight(TILE_SIZE);

        pieceView.setTranslateX(x * TILE_SIZE);
        pieceView.setTranslateY(y * TILE_SIZE);

        FXGL.getGameScene().addUINode(pieceView);
    }

    public void deactivateAllTiles() {
        for (TileOverlay[] row : tileOverlays) {
            for (TileOverlay tileOverlay : row) {
                tileOverlay.deactivate();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}