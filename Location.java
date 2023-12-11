package base;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Location extends SpacePlace {
    public int column;
    public int row;
    public DIRECTION direction;
    public int tmp;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Location(int row, int column, DIRECTION direction) {
        this(row, column);
        this.direction = direction;
    }

    public static int getInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (Exception e) {
            }
        } while (true);
    }

    public String toString() {
        int tmp = column + 1;
        if (direction == null) {
            return "(" + tmp + "," + (row + 1) + ")";
        } else {
            return "(" + tmp + "," + (row + 1) + "," + direction + ")";
        }
    }

    public void drawGridLines(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        drawHorizontalLines(graphics);
        drawVerticalLines(graphics);
    }

    public void drawHorizontalLines(Graphics graphics) {
        for (int tmp = 0; tmp <= 7; tmp++) {
            graphics.drawLine(20, 20 + tmp * 20, 180, 20 + tmp * 20);
        }
    }

    public void drawVerticalLines(Graphics graphics) {
        for (int see = 0; see <= 8; see++) {
            graphics.drawLine(20 + see * 20, 20, 20 + see * 20, 160);
        }
    }

    public enum DIRECTION {VERTICAL, HORIZONTAL}
}
