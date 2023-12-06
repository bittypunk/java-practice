package GardenProgram;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * See the Lab 8 Questions.md file for the instructions.
 * Don't forget to add screenshots of your program's GUI running.
 * Save the screenshots in the screenshots directory of this project.
 */

public class GardenGUI extends JFrame {
    JPanel mainPanel;
    JPanel dataEntryPanel;
    JPanel invoicePreviewPanel;

    JTextArea invoicePreviewTextArea;
    JButton saveInvoiceButton;
    JTextField customerNameTextField;
    JTextField customerAddressTextField;
    JButton generateInvoicePreviewButton;
    JSpinner serviceDateSpinner;
    JCheckBox mowingServiceCheckBox;
    JLabel mowingServiceCost;
    private JComboBox gardenSizeComboBox;
    private JCheckBox leafRakingCheckBox;
    private JLabel leafRakingCost;
    private JLabel invoiceTotal;

    // message variables
    int type1 = JOptionPane.ERROR_MESSAGE;
    int type2 = JOptionPane.INFORMATION_MESSAGE;

    // formatting
    DecimalFormat priceFormat = new DecimalFormat("#.00");
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    GardenGUI() {
        setTitle("Garden Service Invoice");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(1000, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

            configureDateSpinner();   // Sets up the date spinner for you.

            configureEventHandlers();
    }
    int size = gardenSizeComboBox.getSelectedIndex();
    double multiplier = mult(size);

    // figure out the multiplier
    private double mult(int size) {
        double multiplier = 1;

        if (size == 2) { multiplier = GardenServiceData.MEDIUM_PRICE_MULTIPLY; }

        if (size == 3) { multiplier = GardenServiceData.LARGE_PRICE_MULTIPLY; }
        return multiplier;
    }

    private HashMap<String, String> configureCustomerInfo() {
        // create new map
       HashMap<String, String> customerInfo = new HashMap<>();

       // put all the fields into the map
       customerInfo.put("NAME", customerNameTextField.getText());
       customerInfo.put("ADDRESS", customerAddressTextField.getText());
       customerInfo.put("DATE", dateFormat.format(serviceDateSpinner));
       customerInfo.put("GARDEN_SIZE", gardenSizeComboBox.getSelectedItem().toString());
       customerInfo.put("MOWING", ((GardenServiceData.MOWING * multiplier) + ""));
       customerInfo.put("LEAVES", ((GardenServiceData.LEAF_RAKING * multiplier) + ""));
       customerInfo.put("TOTAL", (updateTotal(multiplier) + ""));

       // return the map
       return customerInfo;
    }

    // places static fees on the GUI
    private void configureStaticFees() {
        leafRakingCost.setText(GardenServiceData.LEAF_RAKING + "");

        mowingServiceCost.setText(GardenServiceData.MOWING + "");
    }

    // configures the gardenSizes options
    private void configureComboBox() {

        for (String s : GardenServiceData.gardenSizes) {
            gardenSizeComboBox.addItem(s);
        }
    }

    private void configureEventHandlers() {
            try {
                // configure the comboBox
                configureComboBox();

                // place the fees on the GUI
                configureStaticFees();

                // create customer map
                HashMap<String, String> customerInfo = configureCustomerInfo();

                // listens for a property change, then updates the total
                mainPanel.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                        double total = updateTotal(multiplier);
                        invoiceTotal.setText(priceFormat.format(total));
                    }
                });

                // listens for

                // action when preview button is clicked
                generateInvoicePreviewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String invoice = InvoiceGenerator.generate(customerInfo);
                        invoicePreviewTextArea.setText(invoice);
                    }
                });

                // action when save invoice button is clicked
                saveInvoiceButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // the invoice
                        String invoice = InvoiceGenerator.generate(customerInfo);

                        // if invoice preview is empty, show a message
                        if (invoicePreviewTextArea.toString() == "" || invoicePreviewTextArea.toString() == null) {
                            showMessageDialog("Invoice is empty", "Empty Invoice", type2);
                        } else {
                            // put the date into a string
                            String date = serviceDateSpinner.getValue().toString();


                            try {
                                // create file, or overwrite
                                InvoiceWriter.createFileName(customerInfo.get("NAME"), dateFormat.parse(date) );
                                // write to file
                                InvoiceWriter.writeToFile(customerInfo.get("NAME"), invoice);
                            } catch (ParseException ex) {
                                showMessageDialog("Date Parsing Error", "Parsing Exception", type1);
                            }



                        }
                    }
                });
            } catch (Exception e) {

                showMessageDialog("Error", e.toString(), type1);
            }
    }

    // figure out the total for mowing
    private double mowingTotal(double multiplier) {
        double total = 0;

        // if mowing was involved, add the mowing fee and multiply by size
        if (mowingServiceCheckBox.isSelected()) {
            total += GardenServiceData.MOWING * multiplier;
        }
        return total;
    }

    // figure out the total for raking
    private double rakingTotal(double multiplier) {
        double total = 0;

        // if raking was involved, add raking fee times multiplier
        if (leafRakingCheckBox.isSelected()) {
            total += GardenServiceData.LEAF_RAKING * multiplier;
        }
        return total;
    }

    // figure out the whole total
    private double updateTotal(double multiplier) {
        double total = 0;

        // add the mowing and raking total
        total += mowingTotal(multiplier);
        total += rakingTotal(multiplier);

        return total;
    }



    // method to show an alert dialog
    // type can be JOptionPane.ERROR_MESSAGE, or JOptionPane.INFORMATION_MESSAGE
    void showMessageDialog(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }


    // You don't need to modify this method.
    private void configureDateSpinner() {

        // Dates between Jan 1, 1970 and some time in 2920. I don't suppose this program will be around this long though...
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), new Date(0), new Date(30000000000000L), Calendar.DAY_OF_YEAR);
        serviceDateSpinner.setModel(spinnerDateModel);
        // Create a DateEditor to configure the way dates are displayed and edited
        // Define format the dates will have - month, day, year
        JSpinner.DateEditor editor = new JSpinner.DateEditor(serviceDateSpinner, "MM-dd-yyyy");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        // Attempt to prevent invalid input
        formatter.setAllowsInvalid(false);
        // Allow user to type as well as use up/down buttons
        formatter.setOverwriteMode(true);
        // And tell the serviceDataSpinner to use this Editor
        serviceDateSpinner.setEditor(editor);
    }
}
