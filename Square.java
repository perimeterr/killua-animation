/** The Square class is one of the basic shapes used for the animated scene. It makes use of the built-in Rectangle2D.Double class in java's awt package.
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

public class Square extends DrawingObject{

    private Rectangle2D.Double square;

    // Constructor initializes the required fields based on the DrawingObject class's constructor
    public Square(double x, double y, double w, double h, Color c){
        super(x,y,w,h,c);
        square = new Rectangle2D.Double(x1, y1, w, h);
    }

    // Draws the square using the Graphics2D object
    public void draw(Graphics2D g2d) {
        g2d.setColor(baseColor);
        g2d.fill(square);
    }
}
