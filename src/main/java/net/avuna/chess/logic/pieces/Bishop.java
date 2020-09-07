package net.avuna.chess.logic.pieces;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.ui.Square;

import java.util.Collection;
import java.util.HashSet;

public class Bishop extends Piece {

    private static final int[] MOVE_OFFSETS = {-9, -7, 7, 9};

    public Bishop(ChessColor color) {
        super(color);
    }

    @Override
    public Collection getLegalMoves(Square currentSquare, ChessBoard board) {
        Collection<Square> legalMoves = new HashSet<>();
        for(int offset : MOVE_OFFSETS) {
            int current = currentSquare.get1DIndex();
            while(isLegalMove(current)) {
                Square square = board.getSquare1D(current);
                legalMoves.add(square);
                current += offset;
                if(!square.equals(currentSquare) && square.getPiece() != null) {
                    break;
                }
            }
        }
        legalMoves.removeIf(square -> !isLegalMove(square));
        return legalMoves;
    }
}
