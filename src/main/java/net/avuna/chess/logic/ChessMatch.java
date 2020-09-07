package net.avuna.chess.logic;

import net.avuna.chess.ui.Square;

public class ChessMatch {

    private ChessColor playerToMove = ChessColor.WHITE;

    private final String whitePlayer;
    private final String blackPlayer;

    private final ChessBoard board = new ChessBoard();

    public ChessMatch(String playerOne, String playerTwo) {
        String[] players = {playerOne, playerTwo};
        this.whitePlayer = players[0];
        this.blackPlayer = players[1];
    }

    public void move(Square from, Square to) {
        if(from.equals(to)) {
            //don't allow capturing of self
            return;
        }
        /*if(from.getPiece() != null && !from.getPiece().getLegalMoves().contains(to)) {
            //don't allow illegal moves
            return;
        }*/
        Piece movedPiece = from.getPiece();
        Piece capturedPiece = to.getPiece();
        from.setPiece(null);
        to.setPiece(movedPiece);

        playerToMove = playerToMove.equals(ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public String getBlackPlayer() {
        return whitePlayer;
    }

    public ChessColor getPlayerToMove() {
        return playerToMove;
    }

    public ChessBoard getBoard() {
        return board;
    }
}
