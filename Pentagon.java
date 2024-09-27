/** The Pentagon class is one of the basic shapes used for the animated scene. It makes use of the built-in Polygon class in java's awt package.
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

public class Pentagon extends DrawingObject{

    private Polygon pentagon;

    // Constructor initializes the required fields based on the DrawingObject class's constructor and calculates the coordinates for all the points to create the polygon
    public Pentagon (double x, double y, double s, Color c) {
        super(x,y,s,c);
        double[] xpoints = {x1, x1 + size / 2, x1 + size, x1 + (size * 0.625), x1 + (size * 0.375)};
        double[] ypoints = {y1, y1 - size / 2, y1, y1 + (size * 0.75), y1 + (size * 0.75)};
        int npoints = 5;

        pentagon = new Polygon();
        for (int i = 0; i < npoints; i++) {
            pentagon.addPoint((int) xpoints[i], (int) ypoints[i]);
        }
    }

    // Draws the hexagon using the Graphics2D object
    public void draw(Graphics2D g2d) {
        g2d.setColor(baseColor);
        g2d.fill(pentagon);
    }

}
