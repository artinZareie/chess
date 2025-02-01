module chess.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires annotations;

    opens chess.chess to javafx.fxml;
    opens assets.textures;
    exports chess.chess;
    exports logic;
    exports logic.pieces;
    exports logic.directions;
}