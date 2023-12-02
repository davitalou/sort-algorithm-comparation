package finalexamm.display.modeframe;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainDisplay extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ModePanel display1;
    private SingleModePanel display2;
    private CompareModePanel display3;
    private CustomCodeModePanel display4;

    public MainDisplay() {
        initComponents();
        setTitle("Sorting Algorithm Visualizer:");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(815, 540);
        setLocationRelativeTo(null);

        // Disable window resizing
        setResizable(false);
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        display1 = new ModePanel();
        display2 = new SingleModePanel();
        display3 = new CompareModePanel();
        display4 = new CustomCodeModePanel();

        cardPanel.add(display1, "display1");
        cardPanel.add(display2, "display2");
        cardPanel.add(display3, "display3");
        cardPanel.add(display4, "display4");

        add(cardPanel);

        display1.getSingleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display2");
            }
        });

        display2.getBackSingleMode().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display1");
            }
        });

        display1.getCompareButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display3");
            }
        });

        display3.getBackCompareMode().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display1");
            }
        });

        display1.getCustomCodeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display4");
            }
        });

        display4.getBackCustomCodeMode().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "display1");
            }
        });
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });
    }
}