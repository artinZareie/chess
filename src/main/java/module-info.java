module chess.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens chess.chess to javafx.fxml;
    opens assets.textures;
    exports chess.chess;
}