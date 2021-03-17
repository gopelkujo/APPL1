/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gopel
 */
abstract class Shape {
    private final String shapeName;
    public Shape(String sN){
        shapeName = sN;
    }
    abstract double area();
    
    @Override
    public String toString(){
        return shapeName;
    }
}
