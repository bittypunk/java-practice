package HelloGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloGUI extends JFrame{   // a JFrame is GUI window
    private JPanel mainPanel;
    private JButton clickMeButton;
    private JLabel myFirstLabel;


    // constructor
    protected HelloGUI() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // an anonymous inner class
        // common way of implementing event handlers

        // this displays "Hello GUI" when the click me! button is pressed
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myFirstLabel.setText("Hello, GUI!");
            }
        });
    }
}
