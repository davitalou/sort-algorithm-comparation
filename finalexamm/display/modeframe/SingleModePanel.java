package finalexamm.display.modeframe;

import finalexamm.defaultsorting.*;

import finalexamm.defaultsorting.BubbleSort;
import finalexamm.defaultsorting.InsertionSort;
import finalexamm.defaultsorting.MergeSort;
import finalexamm.defaultsorting.QuickSort;
import finalexamm.defaultsorting.SelectionSort;
import finalexamm.display.SortingDisplay;
import finalexamm.display.modeframe.ModeInterface;
import sorting.task1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class SingleModePanel extends JPanel implements ModeInterface {
    // Behavioral variables
    private Sorting sorting;
    private int[] array;

    // Display variable
    private JLabel algorithmNameLabel;
    private JButton backSingleMode;
    private JComboBox<String> singleComboBox;
    private JLabel singleModeMessenger;
    private JPanel singleSortPanel;
    private JButton singleStartButton;
    private JButton resetArray;

    // Getter and Setter
    public JButton getBackSingleMode() {
        return backSingleMode;
    }
    public void setArray(int[] array) {
        this.array = array;
    }

    public SingleModePanel() {
        initComponents();
        this.array = SortingDisplay.generateRandomArray(200);
        this.sorting = new BubbleSort(array);
        //this.sorting.sortingDisplay.sorting = this.sorting;
        //this.sorting.sortingDisplay.setMode(true);
        //sorting.sortingDisplay.setWidth(799);
        //sorting.sortingDisplay.setHeight(355);
        //sorting.sortingDisplay.setSize(799,355);
        //sorting.sortingDisplay.setSize(799, 355);
        singleSortPanel.add(sorting.getSortingDisplay());
    }

    private void initComponents() {
        // Adjust size and background color
        setBackground(new Color(51, 51, 51));
        setSize(new Dimension(800, 500));

        // Back button
        backSingleMode = new JButton();
        backSingleMode.setBackground(new Color(0, 204, 204));
        backSingleMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backSingleMode.setText("Back");

        // Name of Mode
        singleModeMessenger = new JLabel();
        singleModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        singleModeMessenger.setForeground(new Color(255, 255, 255));
        singleModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        singleModeMessenger.setText("Single mode");

        // ComboBox
        singleComboBox = new JComboBox<>();
        singleComboBox.setBackground(new Color(0, 204, 204));
        singleComboBox.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        singleComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort",}));
        singleComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singleComboBoxActionPerformed(evt);
            }
        });

        // Start button
        singleStartButton = new JButton();
        singleStartButton.setBackground(new Color(0, 204, 204));
        singleStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        singleStartButton.setText("Start");
        singleStartButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    start();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }));

        // Panel set sortingDissplay
        singleSortPanel = new JPanel();
        singleSortPanel.setBackground(new Color(255, 255, 255));
        GroupLayout singleSortPanelLayout = new GroupLayout(singleSortPanel);
        singleSortPanel.setLayout(singleSortPanelLayout);
        singleSortPanelLayout.setHorizontalGroup(
                singleSortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 733, Short.MAX_VALUE)
        );
        singleSortPanelLayout.setVerticalGroup(
                singleSortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 367, Short.MAX_VALUE)
        );

        // Name of the algorithm
        algorithmNameLabel = new JLabel("Bubble sort");
        algorithmNameLabel.setBackground(new Color(255, 255, 255));
        algorithmNameLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel.setForeground(new Color(255, 255, 255));
        algorithmNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // ResetArray button
        resetArray = new JButton();
        resetArray.setBackground(new Color(0, 204, 204));
        resetArray.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        resetArray.setText("Reset Array");
        resetArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetArray();
            }
        });

        // Set layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(backSingleMode, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(singleComboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                .addGap(115, 115, 115)
                                                .addComponent(singleModeMessenger, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 31, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(singleSortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(resetArray)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(algorithmNameLabel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(144, 144, 144)
                                                                .addComponent(singleStartButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backSingleMode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleComboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(singleModeMessenger, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(singleSortPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(singleStartButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(algorithmNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resetArray, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21))
        );
    }

    private void singleComboBoxActionPerformed(ActionEvent evt) {
        Object selectedItem = singleComboBox.getSelectedItem();

        int[] x = SortingDisplay.generateRandomArray(200);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting.getSortingDisplay() != null) {
            singleSortPanel.remove(sorting.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }
        String selectedText = selectedItem.toString();

        if ("Bubble sort".equals(selectedText)) {
            sorting = new BubbleSort(x);
            sorting.sortingDisplay.setWidth(799);
            sorting.sortingDisplay.setHeight(355);
            sorting.sortingDisplay.setSize(799,355);
            algorithmNameLabel.setText("Bubble sort");
        } else if ("Insertion sort".equals(selectedText)) {
            sorting = new InsertionSort(x);
            sorting.sortingDisplay.setWidth(799);
            sorting.sortingDisplay.setHeight(355);
            sorting.sortingDisplay.setSize(799,355);
            algorithmNameLabel.setText("Insertion sort");
        } else if ("Selection sort".equals(selectedText)) {
            sorting = new SelectionSort(x);
            sorting.sortingDisplay.setWidth(799);
            sorting.sortingDisplay.setHeight(355);
            sorting.sortingDisplay.setSize(799,355);
            algorithmNameLabel.setText("Selection sort");
        } else if ("Quick sort".equals(selectedText)) {
            sorting = new QuickSort(x);
            sorting.sortingDisplay.setWidth(799);
            sorting.sortingDisplay.setHeight(355);
            sorting.sortingDisplay.setSize(799,355);
            algorithmNameLabel.setText("Quick sort");
        } else if ("Merge sort".equals(selectedText)) {
            sorting = new MergeSort(x);
            sorting.sortingDisplay.setWidth(799);
            sorting.sortingDisplay.setHeight(355);
            sorting.sortingDisplay.setSize(799,355);
            algorithmNameLabel.setText("Merge sort");
        } else {
            algorithmNameLabel.setText("Unknown sort");
        }


        // Thêm sortingDisplay mới vào container
        singleSortPanel.add(sorting.getSortingDisplay());
        this.sorting.sortingDisplay.sorting = this.sorting;
    }

    @Override
    public void start() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting.sort();
        });

        sortingThread.start();
    }

    @Override
    public void back() {

    }

    @Override
    public void resetArray() {
        int[] newValues = SortingDisplay.generateRandomArray(200);

        setArray(Arrays.copyOf(newValues, newValues.length));
        this.sorting.setValues(array);
        this.sorting.getSortingDisplay().repaint();
    }
}