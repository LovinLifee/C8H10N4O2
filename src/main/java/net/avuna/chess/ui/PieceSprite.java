package net.avuna.chess.ui;

import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.logic.pieces.*;

import java.awt.image.BufferedImage;

public class PieceSprite {

    private static PieceSet pieceSet = new DefaultPieceSet();

    public static BufferedImage getImage(Piece piece) {
        if(piece instanceof Pawn) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhitePawn() : pieceSet.getBlackPawn();
        } else if(piece instanceof King) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhiteKing() : pieceSet.getBlackKing();
        } else if(piece instanceof Queen) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhiteQueen() : pieceSet.getBlackQueen();
        } else if(piece instanceof Rook) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhiteRook() : pieceSet.getBlackRook();
        } else if(piece instanceof Knight) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhiteKnight() : pieceSet.getBlackKnight();
        } else if(piece instanceof Bishop) {
            return piece.getColor() == ChessColor.WHITE ? pieceSet.getWhiteBishop() : pieceSet.getBlackBishop();
        }
        return null;
    }
}
