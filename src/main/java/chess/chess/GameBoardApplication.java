package chess.chess;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.image.ImageView;

public class GameBoardApplication extends GameApplication {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final String TITLE = "Stupid chess game";

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
        bg.setFitHeight(HEIGHT);

        FXGL.getGameScene().addUINode(bg);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
