package net.avuna.chess.logic;

import net.avuna.chess.logic.pieces.*;
import net.avuna.chess.ui.Square;

import java.util.Collection;
import java.util.Collections;

public abstract class Piece {

    protected ChessColor color;

    public Piece(ChessColor color) {
        this.color = color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

    public ChessColor getColor() {
        return color;
    }

    public Collection<Square> getLegalMoves(Square currentSquare, ChessBoard board) {
        return Collections.emptyList();
    }

    public final static boolean isLegalMove(int index) {
        return index >= 0 && index <= 64;
    }

    public final boolean isLegalMove(Square square) {
        int row = square.getRow();
        int column = square.getColumn();
        return square.getPiece() == null || !square.getPiece().getColor().equals(color) && (row >= 0 && row < 8 && column >= 0 && column < 8);
    }

    public static Piece ofLetter(String letter) {
        char piece = letter.charAt(0);
        if(Character.isAlphabetic(piece)) {
            ChessColor color = Character.isUpperCase(piece) ? ChessColor.WHITE : ChessColor.BLACK;
            switch(letter.toLowerCase()) {
                case "p":
                    return new Pawn(color);
                case "k":
                    return new King(color);
                case "q":
                    return new Queen(color);
                case "n":
                    return new Knight(color);
                case "b":
                    return new Bishop(color);
                case "r":
                    return new Rook(color);
            }
        }
        return null;
    }
}
