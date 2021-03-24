/*
 * MathUtils.java
 * Class for counting factorial.
 */

public class MathUtils { 
    //------------------------------------------------------------- 
    // Returns the factorial of the argument given 
    //------------------------------------------------------------- 
    public static int factorial(int n) { 
        int fac = 1; 
        for (int i=n; i>0; i--) 
            fac *= i; 
        return fac; 
    } 
} 