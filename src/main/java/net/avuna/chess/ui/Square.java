package net.avuna.chess.ui;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.Piece;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Square {

    public static final int RESOLUTION = (GameFrame.WIDTH / ChessBoard.WIDTH);
    private static final Color WHITE_TILE = new Color(238,238,210);
    private static final Color BLACK_TILE = new Color(118,150,86);

    private final int row;
    private final int column;
    private final Rectangle bounds;
    private Piece piece;


    public Square(int row, int column) {
        this.row = row;
        this.column = column;
        this.bounds = new Rectangle(column * RESOLUTION, row * RESOLUTION, RESOLUTION, RESOLUTION);
    }

    public void draw(Graphics2D g) {
        g.setColor(row % 2 == column % 2 ? WHITE_TILE : BLACK_TILE);
        g.fill(bounds);
        if(piece != null) {
            BufferedImage pieceImage = PieceSprite.getImage(piece);
            if(pieceImage != null) {
                g.drawImage(pieceImage, (int) bounds.getCenterX() - pieceImage.getWidth() / 2,
                        (int) bounds.getCenterY() - pieceImage.getHeight() / 2, null);
            }
        }
        /*g.setColor(Color.RED);
        g.drawString(getSquareName(), (int) bounds.getMinX() + 2, (int) bounds.getMinY() + 11);*/
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Rectangle2D getBounds() {
        return bounds;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getSquareName() {
        return Character.toString(('A' + column)) + String.valueOf(8 - row);
    }

    public int get1DIndex() {
        return (row * 8) +  column;
    }
}
