package net.avuna.chess.logic.pieces;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.ChessMatch;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.ui.Square;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

    public King(ChessColor color) {
        super(color);
    }

    @Override
    public Collection<Square> getLegalMoves(Square currentSquare, ChessBoard board) {
        Set<Square> legalMoves = new HashSet<>();
        int row = currentSquare.getRow();
        int column = currentSquare.getColumn();
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(row + i >= 0 && row + i < 8 && column + j >= 0 && column + j < 8) {
                    Square square = board.getSquares()[row + i][column + j];
                    //only allow piece to move to empty squares or ones that aren't of the same color
                    if (square.getPiece() == null || !square.getPiece().getColor().equals(color)) {
                        legalMoves.add(square);
                    }
                }
            }
        }
        return legalMoves;
    }
}
