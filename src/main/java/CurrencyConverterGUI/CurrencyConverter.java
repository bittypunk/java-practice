package CurrencyConverterGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CurrencyConverter extends JFrame {   // extend the JFrame
    private JPanel mainPanel;
    private JLabel eurosResultsLabel;
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JComboBox<String> currencyComboBox;

    private final String EUROS = "Euros";
    private final String POUNDS = "Pounds";

    private Map<String, Double> exchangeRates = Map.of(EUROS, 0.84, POUNDS, 0.75);


    // constructor
    CurrencyConverter() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 300)); // call before pack
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // clicks a button when the enter key is pressed
        getRootPane().setDefaultButton(convertButton);

        currencyComboBox.addItem(EUROS);
        currencyComboBox.addItem(POUNDS);

        // new event
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // read input from JTextField and convert to a double
                String dollarString = dollarsTextField.getText();

                try {
                    double dollars = Double.parseDouble(dollarString);
                    String toCurrency = (String) currencyComboBox.getSelectedItem(); // convert selected item to expected type

                    // get the exchange rate for this currency from the hashmap, using whatever was selected from the JComboBox as the key
                    double exchangeRate = exchangeRates.get(toCurrency);

                    // math
                    double converted = dollars * exchangeRate;

                    // Use format String to show the values with 2 decimal places
                    String resultString = String.format("%.2f dollars is equivalent to %.2f %s", dollars, converted, toCurrency);
                    eurosResultsLabel.setText(resultString);

                } catch (NumberFormatException nfe) {
                    // pop up a dialog box with an error message
                    JOptionPane.showMessageDialog(CurrencyConverter.this,
                            "Please enter numbers without $ or any other characters");

                    // some circumstances might require clearing the JTextField of the invalid input
                    // dollarsTextField.setText("");
                    // going to leave the invalid input this time so that they can see what they typed and correct it
                }

            }
        });
    }
}
