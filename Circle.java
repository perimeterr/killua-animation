/** The Circle class is one of the basic shapes used for the animated scene. It makes use of the built-in Ellipse2D.Double class in java's awt package. It can be created either as a perfect circle or as an ellipse.
    This is a template for a Java file.
    @author Francesca Therese R. Aguilar (200128) & Mikaela C. Paderna (234696)
    @version March 6, 2024
**/
/*
    I have not discussed the Java language code in my program 
    with anyone other than my instructor or the teaching assistants 
    assigned to this course.
    I have not used Java language code obtained from another student, 
    or any other unauthorized source, either modified or unmodified.
    If any Java language code or documentation used in my program 
    was obtained from another source, such as a textbook or website, 
    that has been clearly noted with a proper citation in the comments 
    of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class Circle extends DrawingObject{

    private Ellipse2D.Double circle;

    // Constructor initializes the required fields based on the DrawingObject class's constructor for creating a perfect circle
    public Circle(double x, double y, double s, Color c) {
        super(x,y,s,c);
        circle = new Ellipse2D.Double(x1,y1,size,size);
    }

    // Constructor initializes the required fields based on the DrawingObject class's constructor for creating an elllipse
    public Circle(double x, double y, double w, double h, Color c){
        super(x,y,w,h,c);
        circle = new Ellipse2D.Double(x1, y1, width, height);
    }

    // Draws the circle using the Graphics2D object
    public void draw(Graphics2D g2d) {
        g2d.setColor(baseColor);
        g2d.fill(circle);
    }

}
