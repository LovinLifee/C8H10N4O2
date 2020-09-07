package net.avuna.chess.ui;

import net.avuna.chess.logic.ChessBoard;
import net.avuna.chess.logic.ChessColor;
import net.avuna.chess.logic.ChessMatch;
import net.avuna.chess.logic.Piece;
import net.avuna.chess.logic.pieces.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collection;
import java.util.HashSet;

public class GamePanel implements MouseListener, MouseMotionListener {

    private static final Color hoveredColorFill = new Color(1F, 0F, 0F, 0.3F);
    private static final Color hoveredColorOutline = new Color(0F, 0F, 0F, 1F);
    private static final Color selectedColorFill = new Color(0F, 0F, 1F, 0.3F);
    private static final Color legalMoveColorFill = new Color(1F, 1F, 0F, 1F);
    private static final Stroke thickerLine = new BasicStroke(2);

    private ChessMatch game = new ChessMatch("Hayden", "Colby");
    private Square hoveredSquare;
    private Square selectedSquare;
    private Collection<Square> highlightedSquares = new HashSet<>();

    public void draw(Graphics2D g) {
        for(int row = 0; row < game.getBoard().getSquares().length; row++) {
            for(int column = 0; column < game.getBoard().getSquares()[row].length; column++) {
                game.getBoard().getSquares()[row][column].draw(g);
            }
        }
        if(hoveredSquare != null) {
            g.setColor(hoveredColorFill);
            g.fill(hoveredSquare.getBounds());
            g.setColor(hoveredColorOutline);
            g.draw(hoveredSquare.getBounds());
        }
        if(selectedSquare != null) {
            g.setColor(selectedColorFill);
            g.fill(selectedSquare.getBounds());
            g.setColor(Color.BLACK);
            g.draw(selectedSquare.getBounds());
            Collection<Square> legalMoves = selectedSquare.getPiece().getLegalMoves(selectedSquare, game.getBoard());
            final int diameter = Square.RESOLUTION / 5;
            for(Square s : legalMoves) {
                g.setColor(legalMoveColorFill);
                g.fillOval((int) s.getBounds().getMinX() + diameter * 2, (int) s.getBounds().getMinY() + diameter * 2, diameter, diameter);
                g.setColor(Color.BLACK);
                g.drawOval((int) s.getBounds().getMinX() + diameter * 2, (int) s.getBounds().getMinY() + diameter * 2, diameter, diameter);
            }
        }
        g.setColor(Color.RED);
        g.setStroke(thickerLine);
        for(Square s : highlightedSquares) {
            g.drawOval((int) s.getBounds().getMinX(), (int) s.getBounds().getMinY(), Square.RESOLUTION, Square.RESOLUTION);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hoveredSquare = getSquareAtMousePos(e.getX(), e.getY());
    }

    private Square getSquareAtMousePos(int mouseX, int mouseY) {
        int row = (mouseY / Square.RESOLUTION) % ChessBoard.HEIGHT;
        int column = (mouseX / Square.RESOLUTION) % ChessBoard.WIDTH;
        return game.getBoard().getSquares()[row][column];
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    int typeIndex = 0;

    Piece[] types = {new Pawn(ChessColor.WHITE), new King(ChessColor.WHITE), new Queen(ChessColor.WHITE),
                    new Knight(ChessColor.WHITE), new Bishop(ChessColor.WHITE), new Rook(ChessColor.WHITE)};

    @Override
    public void mousePressed(MouseEvent e) {
        Square square = getSquareAtMousePos(e.getX(), e.getY());
        if(e.getButton() == MouseEvent.BUTTON1) {
            highlightedSquares.clear();
            if(selectedSquare == null) {
                if(square.getPiece() != null) { //&& square.getPiece().getColor().equals(game.getPlayerToMove())) {
                    selectedSquare = square;
                }
            } else {
                game.move(selectedSquare, square);
                selectedSquare = null;
            }
        } else if(e.getButton() == MouseEvent.BUTTON2) {
            Piece piece = types[typeIndex++ % types.length];
            piece.setColor(square.getPiece().getColor());
            square.setPiece(piece);
        } else if(e.getButton() == MouseEvent.BUTTON3) {
            highlightedSquares.add(square);
            selectedSquare = null;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
