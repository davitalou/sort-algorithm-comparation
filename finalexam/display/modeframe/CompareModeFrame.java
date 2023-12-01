package finalexam.display.modeframe;

import finalexam.App;
import finalexam.defaultsorting.*;
import finalexam.display.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CompareModeFrame extends JFrame implements ModeInterface {
    MainFrame mainFrame;
    private Sorting sorting1;
    private String currentSelection1;
    private Sorting sorting2;
    private String currentSelection2;
    public CompareModeFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton backButton = new JButton("Back");
        JButton resetArray = new JButton("Reset Array");
        JComboBox<String> comboBox1 = new JComboBox<>(App.getListSorting().toArray(new String[0]));
        JComboBox<String> comboBox2 = new JComboBox<>(App.getListSorting().toArray(new String[0]));
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setCurrentSelection1((String) comboBox1.getSelectedItem());
                }
            }
        });
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setCurrentSelection2((String) comboBox2.getSelectedItem());
                }
            }
        });
        //comboBox1.setBounds(500, 150, 400, 30);
        //comboBox2.setBounds(790, 300, 150, 30);

        //this.currentSelection = (String) comboBox1.getSelectedItem();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        resetArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetArray();
            }
        });

        // Add buttons to the top panel
        topPanel.add(comboBox1);
        topPanel.add(startButton);
        topPanel.add(backButton);
        topPanel.add(resetArray);
        // Add the top panel to the frame at the top (north)
        add(topPanel, BorderLayout.NORTH);
        topPanel.add(comboBox2);

        // Add the test panel to the center of the frame
        this.sorting1 = new BubbleSort(App.generateRandomArray(100));
        //sorting1.sortingDisplay.setBounds(10, 250, 800, 500);
        this.sorting2 = new BubbleSort(App.generateRandomArray(100));
        //sorting2.sortingDisplay.setBounds(370, 250, 800, 500);
        add(sorting1.sortingDisplay);
        add(sorting2.sortingDisplay);
        //add(this.sorting.getSortingDisplay(), BorderLayout.CENTER);
        setSize(800, 600);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void start() {
        Thread sortingThread = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting1.sort();
            sorting2.sort();
        });
        sortingThread.start();
    }


    @Override
    public void back() {
        setVisible(false);
        mainFrame.showMainFrame();
    }

    @Override
    public void resetArray() {
        int[] newValues = App.generateRandomArray(100);
        this.sorting1.setValues(newValues);
        this.sorting1.getSortingDisplay().setValues(newValues);
        this.sorting1.getSortingDisplay().repaint();
        this.sorting2.setValues(newValues);
        this.sorting2.getSortingDisplay().setValues(newValues);
        this.sorting2.getSortingDisplay().repaint();
    }

    public void setCurrentSelection1(String selection) {
        this.currentSelection1 = selection;
        System.out.println("Change to selection " + selection);
        int[] x = App.generateRandomArray(100);
        if (sorting1.getSortingDisplay() != null) {
            remove(sorting1.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }
        if (selection.equals("Bubble sort")) {
            sorting1 = new BubbleSort(x);
        } else if (selection.equals("Insertion sort")) {
            sorting1 = new InsertionSort(x);
        } else if (selection.equals("Selection sort")) {
            sorting1 = new SelectionSort(x);
        } else if (selection.equals("Quick sort")) {
            sorting1 = new QuickSort(x);
        } else if (selection.equals("Merge sort")) {
            sorting1 = new MergeSort(x);
        } else {
            return;
        }
        sorting1.sortingDisplay.setBounds(10, 100, 800, 500);
        add(sorting1.getSortingDisplay());
    }

    public void setCurrentSelection2(String selection) {
        this.currentSelection2 = selection;
        System.out.println("Change to selection " + selection);
        int[] x = App.generateRandomArray(100);
        if (sorting2.getSortingDisplay() != null) {
            remove(sorting2.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }
        if (selection.equals("Bubble sort")) {
            sorting2 = new BubbleSort(x);
        } else if (selection.equals("Insertion sort")) {
            sorting2 = new InsertionSort(x);
        } else if (selection.equals("Selection sort")) {
            sorting2 = new SelectionSort(x);
        } else if (selection.equals("Quick sort")) {
            sorting2 = new QuickSort(x);
        } else if (selection.equals("Merge sort")) {
            sorting2 = new MergeSort(x);
        } else {
            return;
        }
        sorting2.sortingDisplay.setBounds(500, 300, 800, 500);
        add(sorting2.getSortingDisplay());
    }
}