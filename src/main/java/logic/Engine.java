package logic;

import java.time.Duration;
import java.time.Instant;

public class Engine {
    private static Engine instance;
    private Board board;
    public Player whitePlayer;
    public Player blackPlayer;

    public Engine() {
        board = new Board();
        whitePlayer = new Player("White", Duration.ofMinutes(10));
        blackPlayer = new Player("Black", Duration.ofMinutes(10));
    }

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }

        return instance;
    }

    public Board getBoard() {
        return board;
    }
}
