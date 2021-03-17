/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gopel
 */
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double L, double W) {
        super("Rectangle");
        length = L;
        width = W;
    }
    
    @Override
    public double area() {
        return length*width;
    }
    
    @Override
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
