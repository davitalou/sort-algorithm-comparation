package project.customsorting;

/*import finalexam.defaultsorting.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CustomSorting extends Sorting {
    private static final String GENERATED_PACKAGE = "finalexam.customsorting";

    private JFrame frame;
    private JTextArea inputTextArea;

    public CustomSorting() {
        super();
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("Sorting Logic Input");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputTextArea = new JTextArea();
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void handleInput() {
        String userCodeInput = inputTextArea.getText();

        while (!isValidCode(userCodeInput)) {
            JOptionPane.showMessageDialog(frame, "Invalid code. Please try again.");
            return;
        }

        String algorithmName = JOptionPane.showInputDialog(
                "Enter name of the algorithm (The name must comply with Java's class naming rules):");
        while (!isValidName(algorithmName)) {
            if (algorithmName == null) {
                return;
            }
            JOptionPane.showMessageDialog(frame, "Invalid algorithm name. Please try again.");

            algorithmName = JOptionPane.showInputDialog(
                    "Enter name of the algorithm (The name must comply with Java's class naming rules):");
        }

        generateJavaSortingCode(userCodeInput, algorithmName);
        frame.setVisible(false);
    }

    private boolean generateAndCompileAlgorithm(String userCodeInput) {
        generateJavaTestingCode(userCodeInput);
        return compileAlgorithm();
    }

    private void generateJavaTestingCode(String userCodeInput) {
        try {
            BufferedReader templateReader = new BufferedReader(new FileReader("testing_template.txt"));
            StringBuilder templateContent = new StringBuilder();
            String line;
            while ((line = templateReader.readLine()) != null) {
                templateContent.append(line).append("\n");
            }
            templateReader.close();

            String content2 = templateContent.toString()
                    .replace("{code_here}", userCodeInput);

            try (FileWriter writer = new FileWriter("Testing.java")) {
                writer.write(content2);
                System.out.println("Java file created successfully.");
            } catch (IOException e) {
                System.out.println("Error creating Java file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading template file: " + e.getMessage());
        }
    }

    private void generateJavaSortingCode(String userCodeInput, String algorithmName) {
        try {
            BufferedReader templateReader = new BufferedReader(new FileReader("sorting_template.txt"));
            StringBuilder templateContent = new StringBuilder();
            String line;
            while ((line = templateReader.readLine()) != null) {
                templateContent.append(line).append("\n");
            }
            templateReader.close();

            String content2 = templateContent.toString()
                    .replace("{algorithmName}", algorithmName)
                    .replace("{userInput}", userCodeInput);

            try (FileWriter writer = new FileWriter("./src/finalexam/customsorting/"+algorithmName+".java")) {
                writer.write(content2);
                System.out.println("Java file created successfully.");
            } catch (IOException e) {
                System.out.println("Error creating Java file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading template file: " + e.getMessage());
        }
    }

    private boolean compileAlgorithm() {
        return true;
    }
    private boolean isValidCode(String userCodeInput) {
        return generateAndCompileAlgorithm(userCodeInput);
    }

    private static boolean isValidName(String algorithmName) {
        if (algorithmName == null) return false;
        String regex = "^[A-Za-z_$][A-Za-z\\d_$]*$";
        return algorithmName.matches(regex);
    }

    @Override
    public void sort() {
        // This method is overridden but remains empty for now
    }
}*/