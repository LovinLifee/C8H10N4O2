package net.avuna.chess.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DefaultPieceSet implements PieceSet {

    private static final BufferedImage WHITE_PAWN = createImage('\u2659', 50);
    private static final BufferedImage WHITE_KING = createImage('\u2654', 50);
    private static final BufferedImage WHITE_QUEEN = createImage('\u2655', 50);
    private static final BufferedImage WHITE_ROOK = createImage('\u2656', 50);
    private static final BufferedImage WHITE_KNIGHT = createImage('\u2658', 50);
    private static final BufferedImage WHITE_BISHOP = createImage('\u2657', 50);

    private static final BufferedImage BLACK_PAWN = createImage('\u265F', 50);
    private static final BufferedImage BLACK_KING = createImage('\u265A', 50);
    private static final BufferedImage BLACK_QUEEN = createImage('\u265B', 50);
    private static final BufferedImage BLACK_ROOK = createImage('\u265C', 50);
    private static final BufferedImage BLACK_KNIGHT = createImage('\u265E', 50);
    private static final BufferedImage BLACK_BISHOP = createImage('\u265D', 50);


    @Override
    public BufferedImage getWhitePawn() {
        return WHITE_PAWN;
    }

    @Override
    public BufferedImage getWhiteKing() {
        return WHITE_KING;
    }

    @Override
    public BufferedImage getWhiteQueen() {
        return WHITE_QUEEN;
    }

    @Override
    public BufferedImage getWhiteRook() {
        return WHITE_ROOK;
    }

    @Override
    public BufferedImage getWhiteBishop() {
        return WHITE_BISHOP;
    }

    @Override
    public BufferedImage getWhiteKnight() {
        return WHITE_KNIGHT;
    }

    @Override
    public BufferedImage getBlackPawn() {
        return BLACK_PAWN;
    }

    @Override
    public BufferedImage getBlackKing() {
        return BLACK_KING;
    }

    @Override
    public BufferedImage getBlackQueen() {
        return BLACK_QUEEN;
    }

    @Override
    public BufferedImage getBlackRook() {
        return BLACK_ROOK;
    }

    @Override
    public BufferedImage getBlackBishop() {
        return BLACK_BISHOP;
    }

    @Override
    public BufferedImage getBlackKnight() {
        return BLACK_KNIGHT;
    }

    private static BufferedImage createImage(char character, int fontSize) {
        String piece = String.valueOf(character);
        BufferedImage image = new BufferedImage(Square.RESOLUTION, Square.RESOLUTION, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("serif", Font.PLAIN, fontSize);
        g.setFont(font);
        g.setColor(Color.BLACK);
        FontMetrics metrics = g.getFontMetrics(font);
        g.drawString(piece, (image.getWidth() / 2) - metrics.stringWidth(piece) / 2,
                (image.getHeight() / 2) + metrics.getHeight() / 4);
        return image;
    }
}
