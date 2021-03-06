/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gopel
 */
public class Cylinder extends Shape {
    private double radius;
    private double height;
    
    public Cylinder(double R, double H) {
        super("Cylinder");
        radius = R;
        height = H;
    }
    
    @Override
    public double area() {
        return Math.PI*(radius*radius)*height;
    }
    
    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " & height " + height;
    }
}
