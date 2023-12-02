package finalexamm.display.modeframe;

import finalexamm.defaultsorting.*;
import finalexamm.display.modeframe.ModeInterface;
import finalexamm.display.SortingDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class CompareModePanel extends JPanel implements ModeInterface {
    // Behavioral variables
    private Sorting sorting1;
    private Sorting sorting2;
    private int[] array1;
    private int[] array2;

    // Display variable
    private JLabel algorithmNameLabel1;
    private JLabel algorithmNameLabel2;
    private JButton backCompareMode;
    private JComboBox<String> compareComboBox1;
    private JComboBox<String> compareComboBox2;
    private JLabel compareModeMessenger;
    private JPanel comparePanel1;
    private JPanel comparePanel2;
    private JButton compareStartButton;
    private JButton resetArray;

    // Getter and setter
    public JButton getBackCompareMode() {
        return backCompareMode;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }

    public CompareModePanel() {
        initComponents();
        this.array1 = SortingDisplay.generateRandomArray(200);
        this.sorting1 = new BubbleSort(array1);
        comparePanel1.add(sorting1.getSortingDisplay());
        //this.sorting1.sortingDisplay.sorting = this.sorting1;
        //this.sorting1.sortingDisplay.setMode(false);
        //sorting1.sortingDisplay.setWidth(799);
        //sorting1.sortingDisplay.setHeight(171);
        //sorting1.sortingDisplay.setSize(799,171);

        this.array2 = SortingDisplay.generateRandomArray(200);
        this.sorting2 = new BubbleSort(array2);
        comparePanel2.add(sorting2.getSortingDisplay());
        //this.sorting2.sortingDisplay.sorting = this.sorting2;
        //this.sorting2.sortingDisplay.setMode(false);
        //sorting2.sortingDisplay.setWidth(799);
        //sorting2.sortingDisplay.setHeight(171);
        //sorting2.sortingDisplay.setSize(799, 171);
        //this.sorting2.sortingDisplay.setSize(799, 171);
    }

    private void initComponents() {
        // Adjust size and background color
        setBackground(new Color(51, 51, 51));
        setSize(new Dimension(800, 500));

        // Back button
        backCompareMode = new JButton();
        backCompareMode.setBackground(new Color(0, 204, 204));
        backCompareMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backCompareMode.setText("Back");

        // Name of Mode
        compareModeMessenger = new JLabel();
        compareModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        compareModeMessenger.setForeground(new Color(255, 255, 255));
        compareModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        compareModeMessenger.setText("Compare Mode");

        // ComboBox1
        compareComboBox1 = new JComboBox<>();
        compareComboBox1.setBackground(new Color(0, 204, 204));
        compareComboBox1.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort"}));
        compareComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox1ActionPerformed(evt);
            }
        });

        // ComboBox2
        compareComboBox2 = new JComboBox<>();
        compareComboBox2.setBackground(new Color(0, 204, 204));
        compareComboBox2.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort"}));
        compareComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox2ActionPerformed(evt);
            }
        });

        // start button
        compareStartButton = new JButton();
        compareStartButton.setBackground(new Color(0, 204, 204));
        compareStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        compareStartButton.setText("Start");
        compareStartButton.addActionListener((new ActionListener() {
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
        comparePanel1 = new JPanel();
        comparePanel1.setBackground(new Color(255, 255, 255));
        GroupLayout comparePanel1Layout = new GroupLayout(comparePanel1);
        comparePanel1.setLayout(comparePanel1Layout);
        comparePanel1Layout.setHorizontalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 733, Short.MAX_VALUE)
        );
        comparePanel1Layout.setVerticalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 171, Short.MAX_VALUE)
        );

        // Panel set sortingDissplay
        comparePanel2 = new JPanel();
        comparePanel2.setBackground(new Color(255, 255, 255));
        GroupLayout comparePanel2Layout = new GroupLayout(comparePanel2);
        comparePanel2.setLayout(comparePanel2Layout);
        comparePanel2Layout.setHorizontalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 734, Short.MAX_VALUE)
        );
        comparePanel2Layout.setVerticalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 171, Short.MAX_VALUE)
        );

        // Name of the algorithm 1
        algorithmNameLabel1 = new JLabel("Bubble sort");
        algorithmNameLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel1.setForeground(new Color(255, 255, 255));
        algorithmNameLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        // Name of the algorithm 2
        algorithmNameLabel2 = new JLabel("Bubble sort");
        algorithmNameLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel2.setForeground(new Color(255, 255, 255));
        algorithmNameLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        // resetArray button
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
                                                        .addComponent(backCompareMode, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(compareComboBox1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                .addGap(113, 113, 113)
                                                .addComponent(compareModeMessenger)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(compareComboBox2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(algorithmNameLabel1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(resetArray, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(71, 71, 71)
                                                                .addComponent(algorithmNameLabel2, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(compareStartButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 39, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(comparePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(comparePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(compareModeMessenger, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backCompareMode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(compareComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(compareComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(algorithmNameLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(algorithmNameLabel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetArray, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(compareStartButton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void compareComboBox1ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox1.getSelectedItem();
        int[] x = SortingDisplay.generateRandomArray(200);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting1.getSortingDisplay() != null) {
            comparePanel1.remove(sorting1.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }

        String selectedText = selectedItem.toString();

        if ("Bubble sort".equals(selectedText)) {
            sorting1 = new BubbleSort(x);
            sorting1.sortingDisplay.setWidth(799);
            sorting1.sortingDisplay.setHeight(171);
            sorting1.sortingDisplay.setSize(799,171);
            algorithmNameLabel1.setText("Bubble sort");
        } else if ("Insertion sort".equals(selectedText)) {
            sorting1 = new InsertionSort(x);
            sorting1.sortingDisplay.setWidth(799);
            sorting1.sortingDisplay.setHeight(171);
            sorting1.sortingDisplay.setSize(799,171);
            algorithmNameLabel1.setText("Insertion sort");
        } else if ("Selection sort".equals(selectedText)) {
            sorting1 = new SelectionSort(x);
            sorting1.sortingDisplay.setWidth(799);
            sorting1.sortingDisplay.setHeight(171);
            sorting1.sortingDisplay.setSize(799,171);
            algorithmNameLabel1.setText("Selection sort");
        } else if ("Quick sort".equals(selectedText)) {
            sorting1 = new QuickSort(x);
            sorting1.sortingDisplay.setWidth(799);
            sorting1.sortingDisplay.setHeight(171);
            sorting1.sortingDisplay.setSize(799,171);
            algorithmNameLabel1.setText("Quick sort");
        } else if ("Merge sort".equals(selectedText)) {
            sorting1 = new MergeSort(x);
            sorting1.sortingDisplay.setWidth(799);
            sorting1.sortingDisplay.setHeight(171);
            sorting1.sortingDisplay.setSize(799,171);
            algorithmNameLabel1.setText("Merge sort");
        } else {
            algorithmNameLabel1.setText("Unknown sort");
        }

        // Thêm sortingDisplay mới vào container
        comparePanel1.add(sorting1.getSortingDisplay());
        this.sorting1.sortingDisplay.sorting = this.sorting1;
    }
    private void compareComboBox2ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox2.getSelectedItem();
        int[] x = SortingDisplay.generateRandomArray(200);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting2.getSortingDisplay() != null) {
            comparePanel2.remove(sorting2.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }

        String selectedText = selectedItem.toString();

        if ("Bubble sort".equals(selectedText)) {
            sorting2 = new BubbleSort(x);
            sorting2.sortingDisplay.setWidth(799);
            sorting2.sortingDisplay.setHeight(171);
            sorting2.sortingDisplay.setSize(799,171);
            algorithmNameLabel2.setText("Bubble sort");
        } else if ("Insertion sort".equals(selectedText)) {
            sorting2 = new InsertionSort(x);
            sorting2.sortingDisplay.setWidth(799);
            sorting2.sortingDisplay.setHeight(171);
            sorting2.sortingDisplay.setSize(799,171);
            algorithmNameLabel2.setText("Insertion sort");
        } else if ("Selection sort".equals(selectedText)) {
            sorting2 = new SelectionSort(x);
            sorting2.sortingDisplay.setWidth(799);
            sorting2.sortingDisplay.setHeight(171);
            sorting2.sortingDisplay.setSize(799,171);
            algorithmNameLabel2.setText("Selection sort");
        } else if ("Quick sort".equals(selectedText)) {
            sorting2 = new QuickSort(x);
            sorting2.sortingDisplay.setWidth(799);
            sorting2.sortingDisplay.setHeight(171);
            sorting2.sortingDisplay.setSize(799,171);
            algorithmNameLabel2.setText("Quick sort");
        } else if ("Merge sort".equals(selectedText)) {
            sorting2 = new MergeSort(x);
            sorting2.sortingDisplay.setWidth(799);
            sorting2.sortingDisplay.setHeight(171);
            sorting2.sortingDisplay.setSize(799,171);
            algorithmNameLabel2.setText("Merge sort");
        } else {
            algorithmNameLabel2.setText("Unknown sort");
        }

        // Thêm sortingDisplay mới vào container
        comparePanel2.add(sorting2.getSortingDisplay());
        this.sorting2.sortingDisplay.sorting = this.sorting2;
    }

    @Override
    public void start() throws InterruptedException {
        Thread sortingThread1 = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting1.sort();
        });

        Thread sortingThread2 = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting2.sort();
        });

        sortingThread1.start();
        sortingThread2.start();
    }

    @Override
    public void back() {

    }

    @Override
    public void resetArray() {
        int[] newValues = SortingDisplay.generateRandomArray(200);

        setArray1(Arrays.copyOf(newValues, newValues.length));
        this.sorting1.setValues(array1);
        this.sorting1.getSortingDisplay().repaint();
        this.sorting1.sortingDisplay.sorting = this.sorting1;

        setArray2(Arrays.copyOf(newValues, newValues.length));
        this.sorting2.setValues(array2);
        this.sorting2.getSortingDisplay().repaint();
        this.sorting2.sortingDisplay.sorting = this.sorting2;
    }
}