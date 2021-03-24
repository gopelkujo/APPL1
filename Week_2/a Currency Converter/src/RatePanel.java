/*
 * RatePanel.java
 * Frame design using java swing and convert process.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
public class RatePanel extends JPanel{
    private double[] rate;
    private String[] currencyName;
    private JLabel result;
    private JComboBox currency_combo_box;
    private JButton convert_button;
    private JTextField user_input;
    
    public RatePanel() {
        // set up
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("How much is that in dollars?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));
        currencyName = new String[] {"Select the currency..", "European Euro", "Canadian Dollar", "Japanese Yen", "Australian DOllar", "Indian Rupee", "Mexican Peso"};
        currency_combo_box = new JComboBox(currencyName);
        rate = new double [] {0.0, 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880};
        user_input = new JTextField(24);
        user_input.setText("0");
        convert_button = new JButton("Convert");
        result = new JLabel(" ------------- ");
        convert_button.addActionListener(new ComboListener());
        JLabel position_cleaner = new JLabel(""); // making a good position with position_cleaner
        
        // set positioning
        Insets insets = this.getInsets();
        Dimension size;
        size = title.getPreferredSize();
        title.setBounds(20 + insets.left, 10 + insets.top, size.width, size.height);
        size = user_input.getPreferredSize();
        user_input.setBounds(20 + insets.left, 40 + insets.top, size.width, size.height);
        size = currency_combo_box.getPreferredSize();
        currency_combo_box.setBounds(20 + insets.left, 65 + insets.top, size.width, size.height);
        size = convert_button.getPreferredSize();
        convert_button.setBounds(170 + insets.left, 65 + insets.top, size.width + 39, size.height - 1);
        size = result.getPreferredSize();
        result.setBounds(20 + insets.left, 100 + insets.top, size.width + 200, size.height);
        
        // adding item to frame
        add(title);
        add(user_input);
        add(currency_combo_box);
        add(convert_button);
        add(result);
        add(position_cleaner);
    }
    
    // Represents an action listener for the combo box.
    public class ComboListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int index = 0;
            try {
                System.out.println(user_input.getText());
                if(currency_combo_box.getSelectedIndex() != 0)
                    result.setText(currencyName[currency_combo_box.getSelectedIndex()] + " = " + (rate[currency_combo_box.getSelectedIndex()]*Double.parseDouble(user_input.getText())) + " U.S. Dollars");
                else
                    showMessageDialog(null, "Select the currency first.");
            } catch(NumberFormatException e) {
                showMessageDialog(null, "Fill the form please.");
            }
        }
    }
}