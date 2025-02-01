package logic;

public class Engine {
    private static Engine instance;
    private Board board;

    public Engine() {
        board = new Board();
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
