/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gopel
 */
public class Salesperson implements Comparable {
    private final String firstName;
    private final String lastName;
    private final int totalSales;
    
    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }
    
    @Override
    public String toString() {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }
    
    @Override
    public int compareTo(Object other) {
        int result;
        if(totalSales<((Salesperson) other).totalSales)
            result = -1;
        else if(totalSales>((Salesperson) other).totalSales)
            result = 1;
        else if(lastName.compareToIgnoreCase(((Salesperson) other).lastName) > 0)
            result = 1;
        else
            result = -1;
        
        return result;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getSales() {
        return totalSales;
    }
}
