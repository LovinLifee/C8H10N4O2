package net.avuna.chess.logic.pieces;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.ChessMatch;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.ui.Square;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    public Rook(ChessColor color) {
        super(color);
    }

    @Override
    public Collection<Square> getLegalMoves(Square currentSquare, ChessBoard board) {
        Set<Square> legalMoves = new HashSet<>();
        //up
        for(int row = currentSquare.getRow(); row >= 0; row--) {
            Square square = board.getSquares()[row][currentSquare.getColumn()];
            legalMoves.add(square);
            if(!square.equals(currentSquare) && square.getPiece() != null) {
                break;
            }
        }
        //down
        for(int row = currentSquare.getRow(); row < 8; row++) {
            Square square = board.getSquares()[row][currentSquare.getColumn()];
            legalMoves.add(square);
            if(!square.equals(currentSquare) && square.getPiece() != null) {
                break;
            }
        }
        //left
        for(int column = currentSquare.getColumn(); column >= 0; column--) {
            Square square = board.getSquares()[currentSquare.getRow()][column];
            legalMoves.add(square);
            if(!square.equals(currentSquare) && square.getPiece() != null) {
                break;
            }
        }
        //right
        for(int column = currentSquare.getColumn(); column < 8; column++) {
            Square square = board.getSquares()[currentSquare.getRow()][column];
            legalMoves.add(square);
            if(!square.equals(currentSquare) && square.getPiece() != null) {
                break;
            }
        }
        legalMoves.removeIf(square -> !super.isLegalMove(square));
        return legalMoves;
    }
}
