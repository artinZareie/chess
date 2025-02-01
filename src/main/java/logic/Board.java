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
                tiles[x][y] = new Tile(x, y, (x + y) % 2 == 0);
            }
        }

        tiles[0][0].setPiece(new Rook(true, 0, 7));
        tiles[1][0].setPiece(new Knight(true, 1, 7));
        tiles[2][0].setPiece(new Bishop(true, 2, 7));
        tiles[3][0].setPiece(new Queen(true, 3, 7));
        tiles[4][0].setPiece(new King(true, 4, 7));
        tiles[5][0].setPiece(new Bishop(true, 5, 7));
        tiles[6][0].setPiece(new Knight(true, 6, 7));
        tiles[7][0].setPiece(new Rook(true, 7, 7));
        for (int x = 0; x < 8; x++) {
            tiles[x][1].setPiece(new Pawn(true, x, 6));
        }

        tiles[0][7].setPiece(new Rook(false, 0, 0));
        tiles[1][7].setPiece(new Knight(false, 1, 0));
        tiles[2][7].setPiece(new Bishop(false, 2, 0));
        tiles[3][7].setPiece(new Queen(false, 3, 0));
        tiles[4][7].setPiece(new King(false, 4, 0));
        tiles[5][7].setPiece(new Bishop(false, 5, 0));
        tiles[6][7].setPiece(new Knight(false, 6, 0));
        tiles[7][7].setPiece(new Rook(false, 7, 0));
        for (int x = 0; x < 8; x++) {
            tiles[x][6].setPiece(new Pawn(false, x, 1));
        }
    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList<>();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                if (tiles[x][y].hasPiece()) {
                    pieces.add(tiles[x][y].getPiece());
                }
            }
        }

        return pieces;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile getTile(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        return tiles[x][y];
    }

    public void move(@NotNull Move move) {
        Tile start = move.getFrom();
        Tile end = move.getTo();

        if (end.hasPiece()) {
            FXGL.getGameScene().removeUINode(end.getPiece().imageView);
        }

        end.setPiece(start.getPiece());
        start.setPiece(null);
    }
}
