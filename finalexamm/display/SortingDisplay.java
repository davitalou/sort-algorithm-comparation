package finalexamm.display;


import finalexamm.defaultsorting.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SortingDisplay extends JPanel{
    private static int width = 799;
    private static int height = 160;
    private static final int DELAY = 5;
    private BufferedImage offScreenImage;
    public Sorting sorting;
    public boolean isSingleMode;

    public static void setWidth(int width) {
        SortingDisplay.width = width;
    }

    public static void setHeight(int height) {
        SortingDisplay.height = height;
    }

    //public void setValues(int[] a) {
       // this.sorting.setValues(a);
   // }

    public SortingDisplay() {
        //setSize(width, height);
    }

    public void setMode(boolean isSingleMode) {
        this.isSingleMode = isSingleMode;
        if (isSingleMode) {
            setSize(799, 355);
        } else {
            setSize(799, 171);
        }
    }

    private void drawArray(Graphics g) {
        int BAR_WIDTH = width / sorting.values.length;
        for (int i = 0; i < sorting.values.length; i++) {
            int x = i * BAR_WIDTH;
            int height = sorting.values[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, SortingDisplay.height - height, BAR_WIDTH, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, SortingDisplay.height - height, BAR_WIDTH, height);
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

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(300);
        }

        return arr;
    }
}