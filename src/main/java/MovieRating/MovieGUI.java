package MovieRating;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField movieTitleTextField;
    private JSlider ratingSlider;
    private JLabel sliderValueLabel;
    private JCheckBox wouldSeeAgainCheckBox;
    private JLabel movieOpinionLabel;
    private JButton quitButton;

    MovieGUI() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        configureEventHandlers();
    }



    private void updateOpinion() {

        String title = movieTitleTextField.getText();

        // if the movie is blank/whitespace, clear opinion text
        if (title.trim().length() == 0) {
            movieOpinionLabel.setText("Enter a movie title");
        }

        // read info from the title, checkbox, and slider, then use to create an opinion string
        else {
            int rating = ratingSlider.getValue();

            boolean seeAgain = wouldSeeAgainCheckBox.isSelected();

            String template = "You rated '%s' %d stars. You %s see again.";

            // ternary operator
            // sets value of a variable based on whether a condition is true/false
            String seeAgainStr = seeAgain ? "would" : "would not";

            String opinion = String.format(template, title, rating, seeAgainStr);

            movieOpinionLabel.setText(opinion);
        }
    }
        private void configureEventHandlers() {

            // moving the ratingSlider updates the sliderValueLabel and updates the opinion String
            ratingSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    String valueLabelText = ratingSlider.getValue() + " stars";
                    sliderValueLabel.setText(valueLabelText);
                    updateOpinion();
                }
            });

            // quit button
            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (JOptionPane.showConfirmDialog(MovieGUI.this, "Are you sure you want to quit?",
                            "Quit", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                        dispose(); // close this JFrame
                    }
                    /*
                    // other JOptionPane msg dialog examples

                    // within event handler, parent is prob className.this
                    // simplest way to show message dialog:
                    JOptionPane.showMessageDialog(MovieGUI.this, "Here's a message!");

                    // customize the titles, also required to specify the dialog type, no icon shown
                    JOptionPane.showMessageDialog(MovieGUI.this, "Here's a message!", "Title", JOptionPane.PLAIN_MESSAGE);
                    // show a dialog with the default java icon

                    JOptionPane.showMessageDialog(MovieGUI.this, "Here's a message!", "Title", JOptionPane.INFORMATION_MESSAGE);

                    // Can customize the icon if desired
                    ImageIcon icon = new ImageIcon("helicopter.png"); // public domain icon from US dpt of transportation
                    JOptionPane.showMessageDialog(MovieGUI.this, "Here's a helicopter!", "Title", JOptionPane.INFORMATION_MESSAGE, icon);

                    // shows a red error icon, can replace with own icon as above
                    JOptionPane.showMessageDialog(MovieGUI.this, "There's an error!", "Error", JOptionPane.ERROR_MESSAGE);

                    // string input
                    String input = JOptionPane.showInputDialog(MovieGUI.this, "Enter the name of a movie");

                */
                }
            });

        // checkbox change listener - updates the opinion string
        wouldSeeAgainCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { updateOpinion(); }
        });

        movieTitleTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // called when a user types/adds text
                updateOpinion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // called when a user deletes text
                updateOpinion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // need this method, doesn't need code in it
            }
        });
    }
}
