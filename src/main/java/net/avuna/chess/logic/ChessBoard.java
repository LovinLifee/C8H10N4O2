package net.avuna.chess.logic;

import net.avuna.chess.ui.Square;

public class ChessBoard {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private static final String[][] DEFAULT_CHESS_BOARD = {
            {"r","n","b","q","k","b","n","r"},
            {"p","p","p","p","p","p","p","p"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"P","P","P","P","P","P","P","P"},
            {"R","N","B","Q","K","B","N","R"}
    };

    private final Square[][] squares = new Square[WIDTH][HEIGHT];

    public ChessBoard() {
        for(int row = 0; row < squares.length; row++) {
            for(int column = 0; column < squares[row].length; column++) {
                Square square = new Square(row, column);
                Piece piece = Piece.ofLetter(DEFAULT_CHESS_BOARD[row][column]);
                square.setPiece(piece);
                squares[row][column] = square;
            }
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    public Square getSquare(int row, int column) {
        return squares[row][column];
    }

    public Square getSquare1D(int number) {
        int row = number / 8;
        int column = number % 8;
        return squares[row][column];
    }
}
