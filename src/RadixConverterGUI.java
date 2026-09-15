/*
----------------------------------------
----------------------------------------
gawa to ni: github.com/chongkuaile
----------------------------------------
----------------------------------------
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadixConverterGUI {

    private JPanel mainpanel;
    private JLabel BaseTypeLabel;
    private JComboBox BaseComboBox;
    private JLabel NumberLabel;
    private JTextField InputField;
    private JLabel OutputLabel;
    private JTextArea OutputArea;
    private JButton ConvertButton;
    private JLabel CreatorName;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Radix Converter");
        frame.setContentPane(new RadixConverterGUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public RadixConverterGUI() {

        // array list of the types of bases
        BaseComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Binary", "Octal", "Decimal", "Hexadecimal"}));

        // listener for the convert button
        ConvertButton.addActionListener(e -> {

            // string variable for the selected base
            String selectedBase = (String) BaseComboBox.getSelectedItem();

            // input from the text field
            String input = InputField.getText();

            // if input is empty, return, dont run code further
            if (input.isEmpty()) {

                // if cinonvert without entering a number, magpprint
                OutputArea.setText("Please enter a number.");
                return;
            }

            // condtional statements to check each bases selected
            if ("Binary".equalsIgnoreCase(selectedBase)) {
                // Binary method/function
                // passes the input var as a string
                ConvertBinary(input);
            } else if ("Decimal".equalsIgnoreCase(selectedBase)) {
                // Decimal method/function
                // passes the input var as a string
                ConvertDecimal(input);
            } else if ("Octal".equalsIgnoreCase(selectedBase)) {
                // Octal method/function
                // passes the input var as a string
                ConvertOctal(input);
            } else if ("Hexadecimal".equalsIgnoreCase(selectedBase)) {
                // Hexa method/function
                // passes the input var as a string
                ConvertHexadecimal(input);
            }
        });
    }


    // Convert Decimal function
    private void ConvertDecimal(String input) {

        // try and catch block
        // if try block catches an error the catch block will run
        try {

            // converts the string input arg to a long value
            // long value is used for increased digits instead of int
            long number = Long.parseLong(input);


            // 3 variables for each converted base
            String binary = Long.toBinaryString(number);
            String octal = Long.toOctalString(number);
            String hexa = Long.toHexString(number);


            // prints the converted bases in the output area
            OutputArea.setText(
                    number + " in binary is: " + binary + "\n" +
                            number + " in octal is: " + octal + "\n" +
                            number + " in hexadecimal is: " + hexa.toUpperCase()
            );

        // prints invalid number when error
        } catch (NumberFormatException ex) {
            OutputArea.setText("Invalid decimal number.");
        }
    }


    // Convert Binary function
    private void ConvertBinary(String input) {

        // try and catch block
        // if try block catches an error the catch block will run
        try {

            // converts the string input arg to a long value
            // long value is used for increased digits instead of int
            long number = Long.parseLong(input);

            // boolean variable set to true initially
            boolean valid = true;

            // for loop used to check each digits in the input
            // checks if the input only has 1 and 0
            for (long checker = number; checker > 0; checker /= 10) {
                if (checker % 10 > 1) {

                    // bool var set to false if it detects any number but 1 and 0
                    // breaks the for loop
                    valid = false;
                    break;
                }
            }


            // if the bool var of valid is set to false then return, dont run the rest of the code
            if (!valid) {
                OutputArea.setText("Invalid binary number.");
                return;
            }


            // 3 variables for each converted base
            int decimal = Integer.parseInt(input, 2);
            String octal = Integer.toOctalString(decimal);
            String hexa = Integer.toHexString(decimal);


            // prints the converted bases in the output area
            OutputArea.setText(
                    input + " in decimal is: " + decimal + "\n" +
                            input + " in octal is: " + octal + "\n" +
                            input + " in hexadecimal is: " + hexa.toUpperCase()
            );

        // prints invalid number when error
        } catch (NumberFormatException ex) {
            OutputArea.setText("Invalid binary number.");
        }
    }


    // Convert Octal function
    private void ConvertOctal(String input) {
        try {

            // converts the string input arg to a long value
            // long value is used for increased digits instead of int
            long number = Long.parseLong(input);


            // boolean variable set to true initially
            boolean valid = true;

            // for loop used to check each digits in the input
            // checks if the input only has 0 to 7 numbers (8-9 are not included)
            for (long checker = number; checker > 0; checker /= 10) {
                if (checker % 10 > 7) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                OutputArea.setText("Invalid octal number.");
                return;
            }

            int decimal = Integer.parseInt(input, 8);
            String binary = Integer.toBinaryString(decimal);
            String hexa = Integer.toHexString(decimal);

            OutputArea.setText(
                    input + " in binary is: " + binary + "\n" +
                            input + " in decimal is: " + decimal + "\n" +
                            input + " in hexadecimal is: " + hexa.toUpperCase()
            );
        } catch (NumberFormatException ex) {
            OutputArea.setText("Invalid octal number.");
        }
    }


    // Convert Hexadecimal function
    private void ConvertHexadecimal(String input) {
        try {

            int decimal = Integer.parseInt(input, 16);
            String binary = Integer.toBinaryString(decimal);
            String octal = Integer.toOctalString(decimal);

            OutputArea.setText(
                    input + " in binary is: " + binary + "\n" +
                            input + " in decimal is: " + decimal + "\n" +
                            input + " in octal is: " + octal.toUpperCase()
            );
        } catch (NumberFormatException ex) {
            OutputArea.setText("Invalid hexadecimal number.");
        }
    }
}
