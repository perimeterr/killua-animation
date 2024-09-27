/** The Logo class is one of the composite shapes drawn in the program. It recreates Hunter X Hunter's iconic logo by using a Square, Lines, and a Pentagon.
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

public class Logo extends DrawingObject {
    private Square base;
    private Line topL1, topL2, topL3;
    private Line botL1, botL2, botL3;
    private Line innerThin1, innerThin2;
    private Line innerThick1, innerThick2;
    private Pentagon center;

    private Color centerColor;

    // Constructor initializes the required fields based on the DrawingObject class's constructor for creating the logo
    public Logo(double x, double y, double s) {
        super(x,y,s);
        centerColor = new Color(204, 0, 0);

    }

    // Increases the logo's size
    public void increaseSize() {
        size += 1;
    }

    // Decreases the logo's size
    public void decreaseSize() {
        size -= 1;
    }

    // Draws all the parts of the logo
    public void draw(Graphics2D g2d) {
        base = new Square(x1 - size, y1 - size, size * 3, size * 2, Color.WHITE);
        topL1 = new Line(x1 - size / 2, y1 - size / 2 - 5, x1 - size * 0.0625, y1 - (size / 2) - 5, 2, Color.BLACK);
        topL2 = new Line(x1 + size * 0.25, y1 - size/2 - 5, x1 + size * 0.75, y1 - size / 2 - 5, 2, Color.BLACK);
        topL3 = new Line(x1 + size * 1.0625, y1 - size / 2 - 5, x1 + size * 1.5625, y1 - size / 2 - 5, 2, Color.BLACK);
        botL1 = new Line(x1 - size / 2, y1 + size * 0.75, x1 - size * 0.0625, y1 + size * 0.75, 2, Color.BLACK);
        botL2 = new Line(x1 + size * 0.25, y1 + size * 0.75, x1 + size * 0.75, y1 + size * 0.75, 2, Color.BLACK);
        botL3 = new Line(x1 + size * 1.0625, y1 + size * 0.75, x1 + size * 1.5625, y1 + size * 0.75, 2, Color.BLACK);
        innerThin1 = new Line(x1 - size * 0.281, y1 - size / 2 - 5, x1 + size * 0.375, y1 + size * 0.75, 2, Color.BLACK);
        innerThin2 = new Line(x1 + size * 0.625, y1 + size * 0.75, x1 + size * 1.3125, y1 - size / 2 - 5, 2, Color.BLACK);
        innerThick1 = new Line(x1 - size * 0.331, y1 + size * 0.73, x1 + size * 0.5, y1 - size /2 - 3, 5, Color.BLACK);
        innerThick2 = new Line(x1 + size * 0.5, y1 - size / 2 - 3, x1 + size * 1.2625, y1 + size * 0.73, 5, Color.BLACK);
        center = new Pentagon(x1,y1,size,centerColor);

        base.draw(g2d);
        topL1.draw(g2d);
        topL2.draw(g2d);
        topL3.draw(g2d);
        botL1.draw(g2d);
        botL2.draw(g2d);
        botL3.draw(g2d);
        center.draw(g2d);
        innerThin1.draw(g2d);
        innerThin2.draw(g2d);
        innerThick1.draw(g2d);
        innerThick2.draw(g2d);
    }
}
