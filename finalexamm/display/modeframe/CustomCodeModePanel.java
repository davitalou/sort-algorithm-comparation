package finalexamm.display.modeframe;

import javax.swing.*;
import java.awt.*;

public class CustomCodeModePanel extends JPanel {
    private JButton backCustomCodeMode;
    private JLabel customCodeMessenger;
    private JScrollPane jScrollPane1;
    private JButton save;
    private JTextArea textEditor;

    public JButton getBackCustomCodeMode() {
        return backCustomCodeMode;
    }

    public JLabel getCustomCodeMessenger() {
        return customCodeMessenger;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JButton getSave() {
        return save;
    }

    public JTextArea getTextEditor() {
        return textEditor;
    }

    public CustomCodeModePanel() {
        initComponents();
    }

    private void initComponents() {
        backCustomCodeMode = new JButton();
        save = new JButton();
        jScrollPane1 = new JScrollPane();
        textEditor = new JTextArea();
        customCodeMessenger = new JLabel();

        setBackground(new Color(51, 51, 51));

        backCustomCodeMode.setBackground(new Color(0, 204, 204));
        backCustomCodeMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backCustomCodeMode.setText("Back");

        save.setBackground(new Color(0, 204, 204));
        save.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        save.setText("Save");

        textEditor.setColumns(20);
        textEditor.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        textEditor.setRows(5);
        jScrollPane1.setViewportView(textEditor);

        customCodeMessenger.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        customCodeMessenger.setForeground(new Color(255, 255, 255));
        customCodeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        customCodeMessenger.setText("Enter your code here!");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backCustomCodeMode, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addGap(138, 138, 138)
                                                .addComponent(customCodeMessenger, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(save, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(backCustomCodeMode)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(customCodeMessenger, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(save)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
    }
}