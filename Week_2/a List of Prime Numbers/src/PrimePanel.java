/*
 * PrimePanel.java
 * up to a number input by the user. 
 */
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class PrimePanel extends JPanel {
    private JTextField number; 
    private JButton computeButton; 
    private JTextArea primeList; 
    private JScrollPane text_scroll_pane;
    // ---------------------------------------------------------- 
    // Sets up a panel with a heading, a labeled text field 
    // for the user to enter an integer, a button to trigger 
    // the calculation, and a text area to display the list 
    // of primes. 
    // ---------------------------------------------------------- 
    public PrimePanel() {
        this.setLayout(new FlowLayout());
        JLabel heading = new JLabel ("Prime Number Listing"); 
        heading.setFont (new Font("Helvetica", Font.BOLD, 30)); 
        JLabel inputLabel = new JLabel ("Enter a number: "); 
        number = new JTextField (8); 
        computeButton = new JButton ("Click to see all primes up to your number!"); 
        primeList = new JTextArea (10, 30); 
        text_scroll_pane = new JScrollPane(primeList);
        text_scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        computeButton.addActionListener(new ButtonListener()); 
        setAutoscrolls(true);
        // Add the components to the panel 
        add(heading); 
        add(inputLabel); 
        add(number); 
        add(computeButton); 
//        add (primeList); 
        add(text_scroll_pane);
        setPreferredSize (new Dimension (400, 320)); 
        setBackground (Color.yellow); 
    }
    
    // ***************************************************************** 
    // Represents a listener for the click of the button. 
    // ***************************************************************** 
    public class ButtonListener implements ActionListener {
        // ----------------------------------------------------------- 
        // Generates and displays a list of primes when the 
        // button is clicked. 
        // ----------------------------------------------------------- 
        @Override
        public void actionPerformed (ActionEvent event) { 
            try {
                String textNum = number.getText(); 
                int num = Integer.parseInt (textNum); 
                String ans = "";
                int count = 0; 
                if (num < 2) 
                    ans = "There no primes less than " + num; 
                else { 
                    ans = " " + 2; 
                    count++; 
                    for (int i = 3; i <= num; i += 2) { 
                        boolean foundDivisor = false; 
                        int j = 3; 
                        while (j < i && !foundDivisor) { 
                            if (i % j == 0) 
                                foundDivisor = true; 
                            else 
                                j++; 
                        } 
                        // Add i to the list if it is prime 
                        if (j == i) { 
                            ans += " " + i; 
                            count++; 
                            if (count % 10 == 0) 
                                ans += "\n"; 
                        }
                    } 
                } 
                primeList.setText (ans);
            } catch (NumberFormatException e) {
                primeList.setText("Fill the form with number please.");
            }
        }
    }
}