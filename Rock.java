/** The Rock class is one of the composite shapes used for the animated scene. It consists of two objects of the Circle class to illustrate a drawing of a rock.
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

public class Rock extends DrawingObject {
    private Circle r1,r2;

    // Constructor initializes the required fields for creating the cloud based on the DrawingObject class's constructor
    public Rock(double x, double y, double s, Color c){
        super(x, y, s, c);
    }

    // Draws the rock using the two circles made with the Graphics2D object
    public void draw(Graphics2D g2d) {
        r1 = new Circle(x1, y1, size, baseColor); //left
        r2 = new Circle(x1 + 5, y1-1.5, size+2, baseColor); //right
        r1.draw(g2d);
        r2.draw(g2d);
    }

}
