package net.avuna.chess.ui;

import java.awt.image.BufferedImage;

public interface PieceSet {
    public BufferedImage getWhitePawn();
    public BufferedImage getWhiteKing();
    public BufferedImage getWhiteQueen();
    public BufferedImage getWhiteRook();
    public BufferedImage getWhiteBishop();
    public BufferedImage getWhiteKnight();

    public BufferedImage getBlackPawn();
    public BufferedImage getBlackKing();
    public BufferedImage getBlackQueen();
    public BufferedImage getBlackRook();
    public BufferedImage getBlackBishop();
    public BufferedImage getBlackKnight();
}
