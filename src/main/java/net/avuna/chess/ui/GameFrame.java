package net.avuna.chess.ui;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameFrame extends JPanel  {

    public static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static ScheduledExecutorService screenUpdateThread = Executors.newSingleThreadScheduledExecutor();

    private final JFrame frame = new JFrame("Hayden's chess game");
    private final GamePanel board = new GamePanel();

    public GameFrame() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
        this.setSize(size);
        this.setMinimumSize(size);
        this.addMouseMotionListener(board);
        this.addMouseListener(board);
        this.frame.add(this);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        board.draw(g2d);
    }

    public void start() {
        frame.setVisible(true);
        final int FPS = 20;
        screenUpdateThread.scheduleAtFixedRate(() -> {
            this.repaint();
        }, 0, (1000 / FPS), TimeUnit.MILLISECONDS);
    }
}
