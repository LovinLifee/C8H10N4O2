package net.avuna.chess.logic.pieces;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.ChessMatch;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.ui.Square;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Knight extends Piece {

    private static final int[][] offsets = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };

    public Knight(ChessColor color) {
        super(color);
    }

    @Override
    public Collection<Square> getLegalMoves(Square currentSquare, ChessBoard board) {
        Collection<Square> legalMoves = new HashSet<>();
        for(int[] offset : offsets) {
            int row = currentSquare.getRow() + offset[0];
            int column = currentSquare.getColumn() + offset[1];
            if(row >= 0 && row < 8 && column >= 0 && column < 8) {
                Square square = board.getSquares()[row][column];
                if (square.getPiece() == null || !square.getPiece().getColor().equals(color)) {
                    legalMoves.add(square);
                }
            }
        }
        return legalMoves;
    }
}
