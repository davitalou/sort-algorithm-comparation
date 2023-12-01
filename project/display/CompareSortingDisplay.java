package project.display;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class CompareSortingDisplay extends JPanel{
    private static final int WIDTH = 200;
    private static final int HEIGHT = 300;
    private static final int DELAY = 5;
    private int[] values;

    private BufferedImage offScreenImage;

    public CompareSortingDisplay() {
        setSize(WIDTH, HEIGHT);
        setBackground(Color.green);
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    protected void drawArray(Graphics g) {
        int BAR_WIDTH = 300 / values.length;
        for (int i = 0; i < values.length; i++) {
            int x = i * BAR_WIDTH;
            int height = values[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, HEIGHT - height, BAR_WIDTH, height);
            g.setColor(Color.BLUE);
            g.fillRect(x + 200, HEIGHT - height, BAR_WIDTH, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, HEIGHT - height, BAR_WIDTH, height);
            g.setColor(Color.BLACK);
            g.drawRect(x + 200, HEIGHT - height, BAR_WIDTH, height);
        }
    }

    public void sleep() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics offScreenGraphics = offScreenImage.getGraphics();
        offScreenGraphics.setColor(Color.WHITE);
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        drawArray(offScreenGraphics);

        g.drawImage(offScreenImage, 0, 0, this);
    }
}
