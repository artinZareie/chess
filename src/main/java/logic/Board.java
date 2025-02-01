package logic;

import logic.pieces.*;

public class Board {
    public final Tile[][] tiles = new Tile[8][8];

    public Board() {

    }

    public void init() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tiles[x][y] = new Tile(x, y, (x + y) % 2 == 0);
            }

            tiles[0][0].setPiece(new Rook(true, 0, 0));
            tiles[1][0].setPiece(new Knight(true, 1, 0));
            tiles[2][0].setPiece(new Bishop(true, 2, 0));
            tiles[3][0].setPiece(new Queen(true, 3, 0));
            tiles[4][0].setPiece(new King(true, 4, 0));
            tiles[5][0].setPiece(new Bishop(true, 5, 0));
            tiles[6][0].setPiece(new Knight(true, 6, 0));
            tiles[7][0].setPiece(new Rook(true, 7, 0));
            for (int x = 0; x < 8; x++) {
                tiles[x][1].setPiece(new Pawn(true, x, 1));
            }

            tiles[0][7].setPiece(new Rook(false, 0, 7));
            tiles[1][7].setPiece(new Knight(false, 1, 7));
            tiles[2][7].setPiece(new Bishop(false, 2, 7));
            tiles[3][7].setPiece(new Queen(false, 3, 7));
            tiles[4][7].setPiece(new King(false, 4, 7));
            tiles[5][7].setPiece(new Bishop(false, 5, 7));
            tiles[6][7].setPiece(new Knight(false, 6, 7));
            tiles[7][7].setPiece(new Rook(false, 7, 7));
            for (int x = 0; x < 8; x++) {
                tiles[x][6].setPiece(new Pawn(false, x, 6));
            }
        }
    }
}
