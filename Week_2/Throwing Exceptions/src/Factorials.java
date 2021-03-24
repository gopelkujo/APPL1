/*
 * Factorials.java
 * Reads integers from the user and prints the factorial of each.
 */

import java.util.Scanner;
public class Factorials { 
    public static void main(String[] args) { 
        String keepGoing = "y"; 
        Scanner scan = new Scanner(System.in); 
        while (keepGoing.equals("y") || keepGoing.equals("Y")) { 
           try {
                System.out.print("Enter an integer: "); 
                int val = scan.nextInt(); 
                if(val<0) {
                    throw new IllegalArgumentException("" + val);
                } else {
                     System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
                } 
            } catch(IllegalArgumentException e) {
                System.out.println("No negative number such as " + e.getMessage() + " please.");
            }
            System.out.print("Another factorial? (y/n) "); 
            keepGoing = scan.next(); 
        } 
    } 
} 