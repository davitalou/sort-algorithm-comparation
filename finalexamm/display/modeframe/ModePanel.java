package finalexamm.display.modeframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModePanel extends JPanel {
    private javax.swing.JButton compareButton;
    private javax.swing.JButton customCodeButton;
    private javax.swing.JLabel messenger1;
    private javax.swing.JButton quit;
    private javax.swing.JButton singleButton;

    public JButton getCompareButton() {
        return compareButton;
    }

    public JButton getCustomCodeButton() {
        return customCodeButton;
    }

    public JLabel getMessenger1() {
        return messenger1;
    }

    public JButton getQuit() {
        return quit;
    }

    public JButton getSingleButton() {
        return singleButton;
    }

    public ModePanel() {
        initComponents();
    }

    private void initComponents() {
        quit = new JButton();
        messenger1 = new JLabel();
        singleButton = new JButton();
        compareButton = new JButton();
        customCodeButton = new JButton();

        setBackground(new Color(51, 51, 51));

        quit.setBackground(new Color(0, 204, 204));
        quit.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        quit.setText("Quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        messenger1.setFont(new Font("Segoe UI", 1, 48)); // NOI18N
        messenger1.setForeground(new Color(255, 255, 255));
        messenger1.setHorizontalAlignment(SwingConstants.CENTER);
        messenger1.setText("Selection");

        singleButton.setBackground(new Color(0, 204, 204));
        singleButton.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        singleButton.setText("Single Mode");
        singleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singleButtonActionPerformed(evt);
            }
        });

        compareButton.setBackground(new Color(0, 204, 204));
        compareButton.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        compareButton.setText("Compare Mode");
        compareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareButtonActionPerformed(evt);
            }
        });

        customCodeButton.setBackground(new Color(0, 204, 204));
        customCodeButton.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        customCodeButton.setText("Your custom code");
        customCodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customCodeButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(quit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(237, 237, 237)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(messenger1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(singleButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(compareButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(customCodeButton, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
                                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(quit)
                                .addGap(14, 14, 14)
                                .addComponent(messenger1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(singleButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(compareButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(customCodeButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(101, Short.MAX_VALUE))
        );
    }

    private void compareButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void singleButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void customCodeButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void quitActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0); // This will exit the application
    }
}