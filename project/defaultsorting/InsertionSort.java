package project.defaultsorting;

import project.display.CompareSortingDisplay;
import project.display.SortingDisplay;

public class InsertionSort extends Sorting {
    public InsertionSort(int[] values) {
        super(values);
        this.sortingDisplay = new SortingDisplay();
        this.sortingDisplay.setValues(values); // Pass the values array to SortingDisplay
        this.sortingDisplay.setVisible(true);
    }

    @Override
    public void sort() {
        int n = values.length;
        for (int i = 1; i < n; i++) {
            int key = values[i];
            int j = i - 1;

            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j = j - 1;
                this.sortingDisplay.repaint();
                this.sortingDisplay.sleep();
            }
            values[j + 1] = key;
        }
    }
}