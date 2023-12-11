/**
 * The PictureFrame class represents the graphical user interface for the Abominodo game.
 * It includes methods for drawing the game grid, dominoes, and other graphical elements.
 * The class is responsible for managing the visual representation of the game during different modes.
 * Note: This class could benefit from further refactoring for improved readability and maintainability.
 */

package base;

import javax.swing.*;
import java.awt.*;

public class PictureFrame {
    public Main master = null;

    class DominoPanel extends JPanel {
        private static final long serialVersionUID = 4190229282411119364L;

        public void drawGrid(Graphics g) {
            for (int are = 0; are < 7; are++) {
                for (int see = 0; see < 8; see++) {
                    drawDigitGivenCentre(g, 30 + see * 20, 30 + are * 20, 20,
                            master.grid[are][see], Color.BLACK);
                }
            }
        }

        public void drawHeadings(Graphics g) {
            for (int are = 0; are < 7; are++) {
                fillDigitGivenCentre(g, 10, 30 + are * 20, 20, are + 1);
            }

            for (int see = 0; see < 8; see++) {
                fillDigitGivenCentre(g, 30 + see * 20, 10, 20, see + 1);
            }
        }

        public void drawDomino(Graphics graphics, Domino domino) {
            if (domino.isPlaced) {
                final int CELL_WIDTH = 20;
                final int CELL_HEIGHT = 20;
                final int DIGIT_OFFSET = 10;

                int topY = Math.min(domino.verticalPositionY, domino.horizontalPositionY);
                int topX = Math.min(domino.verticalPositionX, domino.horizontalPositionX);
                int width = Math.abs(domino.verticalPositionX - domino.horizontalPositionX) + 1;
                int height = Math.abs(domino.verticalPositionY - domino.horizontalPositionY) + 1;

                graphics.setColor(Color.WHITE);
                graphics.fillRect(topX * CELL_WIDTH, topY * CELL_HEIGHT, width * CELL_WIDTH, height * CELL_HEIGHT);
                graphics.setColor(Color.RED);
                graphics.drawRect(topX * CELL_WIDTH, topY * CELL_HEIGHT, width * CELL_WIDTH, height * CELL_HEIGHT);

                drawDigitGivenCentre(graphics,
                        topX * CELL_WIDTH + DIGIT_OFFSET,
                        topY * CELL_HEIGHT + DIGIT_OFFSET,
                        CELL_WIDTH,
                        domino.highValue,
                        Color.BLUE);

                drawDigitGivenCentre(graphics,
                        (topX + width) * CELL_WIDTH - DIGIT_OFFSET,
                        (topY + height) * CELL_HEIGHT - DIGIT_OFFSET,
                        CELL_WIDTH,
                        domino.lowValue,
                        Color.BLUE);
            }
        }

        void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int number,
                Color color) {
            g.setColor(color);
            FontMetrics fm = g.getFontMetrics();
            String txt = Integer.toString(number);
            g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
            int radius = diameter / 2;
            g.setColor(Color.GREEN);
            g.fillOval(x - radius, y - radius, diameter, diameter);
            g.setColor(Color.BLACK);
            g.drawOval(x - radius, y - radius, diameter, diameter);
            FontMetrics fm = g.getFontMetrics();
            String txt = Integer.toString(n);
            g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, getWidth(), getHeight());

            Location location = new Location(1, 2);

            if (master.mode == 1) {
                location.drawGridLines(g);
                drawHeadings(g);
                drawGrid(g);
                master.drawGuesses(g);
            }
            if (master.mode == 0) {
                location.drawGridLines(g);
                drawHeadings(g);
                drawGrid(g);
                master.drawDominoes(g);
            }
        }

        public Dimension getPreferredSize() {
            // the application window always prefers to be 202x182
            return new Dimension(202, 182);
        }
    }

    public DominoPanel dp;

    public void PictureFrame(Main sourceFrame) {
        master = sourceFrame;
        dp = new DominoPanel();
        if (dp == null) {
            JFrame frame = new JFrame("Abominodo");
            frame.setContentPane(dp);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setVisible(true);
        }
    }

}
