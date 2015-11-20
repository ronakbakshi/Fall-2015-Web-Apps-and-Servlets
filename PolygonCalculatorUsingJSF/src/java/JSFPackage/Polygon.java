/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFPackage;

/**
 *
 * @author Ronak Bakshi
 */
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "polygon")
@RequestScoped
public class Polygon {
        int numberOfSides;
        int radius;
        
    
    public Polygon() {
    }
    public int getNumberOfSides() {
        return numberOfSides;
    }
    public int getRadius() {
        return radius;
    }
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }    
    public double getSideLength(){
        return 2 * radius * Math.sin(Math.PI/numberOfSides);
    }
    public double getPerimeter(){
        return numberOfSides * getSideLength();
    }
    public double getArea(){
        return 0.25 * numberOfSides * getSideLength() * getSideLength() / Math.tan(Math.PI/numberOfSides);
    }
}