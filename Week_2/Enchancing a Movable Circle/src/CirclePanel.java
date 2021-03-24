/*
 * CirclePanel.java
 * Configure circle moves.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private Color c;
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");
    
    // Set up circle and buttons to move it.
    public CirclePanel(int width, int height) {
        // Set coordinates so circle starts in middle
        x = (width/2) - (CIRCLE_SIZE/2);
        y = (height/2) - (CIRCLE_SIZE/2);
        
        c = Color.red;
        
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        // Add hotkeys
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
        
        // Add tooltip
        left.setToolTipText("When you press this button, the circle moves 20px to the left.");
        right.setToolTipText("When you press this button, the circle moves 20px to the right.");
        up.setToolTipText("When you press this button, the circle moves 20px to the top.");
        down.setToolTipText("When you press this button, the circle moves 20px to the bottom.");
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    
    // Draw circle on CirclePanel
    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;
        
        // Parameters tell how to move circle at click.
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
        
        // Change x and y coordinates and repaint.
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(x + "\n" + y);
            x += dx;
            if(x < -5) {
                left.setEnabled(false);
            } else {
                left.setEnabled(true);
            }
            if(x > 315) {
                right.setEnabled(false);
            } else {
                right.setEnabled(true);
            }
            y += dy;
            if(y < 5) {
                up.setEnabled(false);
            } else {
                up.setEnabled(true);
            }
            if(y > 165) {
                down.setEnabled(false);
            } else {
                down.setEnabled(true);
            }
            repaint();
        }
    }
}