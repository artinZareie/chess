package logic;

import com.almasb.fxgl.dsl.FXGL;
import logic.pieces.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Tile[][] tiles = new Tile[8][8];

    public Board() {
        this.init();
    }

    public void init() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tiles[y][x] = new Tile(x, y, (x + y) % 2 == 0);
            }
        }

        tiles[0][0].setPiece(new Rook(true, 0, 0));
        tiles[0][1].setPiece(new Knight(true, 1, 0));
        tiles[0][2].setPiece(new Bishop(true, 2, 0));
        tiles[0][3].setPiece(new Queen(true, 3, 0));
        tiles[0][4].setPiece(new King(true, 4, 0));
        tiles[0][5].setPiece(new Bishop(true, 5, 0));
        tiles[0][6].setPiece(new Knight(true, 6, 0));
        tiles[0][7].setPiece(new Rook(true, 7, 0));
        for (int x = 0; x < 8; x++) {
            tiles[1][x].setPiece(new Pawn(true, x, 1));
        }

        tiles[7][0].setPiece(new Rook(false, 0, 7));
        tiles[7][1].setPiece(new Knight(false, 1, 7));
        tiles[7][2].setPiece(new Bishop(false, 2, 7));
        tiles[7][3].setPiece(new Queen(false, 3, 7));
        tiles[7][4].setPiece(new King(false, 4, 7));
        tiles[7][5].setPiece(new Bishop(false, 5, 7));
        tiles[7][6].setPiece(new Knight(false, 6, 7));
        tiles[7][7].setPiece(new Rook(false, 7, 7));
        for (int x = 0; x < 8; x++) {
            tiles[6][x].setPiece(new Pawn(false, x, 6
            ));
        }
    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList<>();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tiles[y][x].hasPiece()) {
                    pieces.add(tiles[y][x].getPiece());
                }
            }
        }

        return pieces;
    }

    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    public Tile getTile(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        return getTile(x, y);
    }

    public boolean isOutOfBounds(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }

    public boolean isValidCoord(int[] pos) {
        return !isOutOfBounds(pos);
    }

    public void move(@NotNull Move move) {
        Tile start = move.getFrom();
        Tile end = move.getTo();

        if (end.hasPiece()) {
            FXGL.getGameScene().removeUINode(end.getPiece().imageView);
        }

        start.getPiece().move(move);
        end.setPiece(start.getPiece());
        start.setPiece(null);
        Engine.getInstance().toggleTurn();
    }

    public boolean isEmpty(int x, int y) {
        return !tiles[y][x].hasPiece();
    }

    public boolean isEmpty(int[] pos) {
        int x = pos[0];
        int y = pos[1];

        return isEmpty(x, y);
    }
}
