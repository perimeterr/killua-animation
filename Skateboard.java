/** The Skateboard class is one of the composite shapes used for the animated scene. It consists of Circles, Squares, a Polygon, and a Hexagon to illustrate a drawing of Killua's skateboard.
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

public class Skateboard extends DrawingObject{
    private Color arrowColor;

    private Circle wheel1, wheel2;
    private Circle side1, side2;
    private Square base;
    private Square arrowLine;
    private Polygon arrowHead;
    private Hexagon bearing1, bearing2;

    // Constructor initializes the required fields for creating the skateboard based on the DrawingObject class's constructor
    public Skateboard(double x, double y, double w, double h){
        super(x,y,w,h, Color.YELLOW);
        
        arrowColor = new Color(204,0,0);
    }

    // Draws the all the parts of the Skateboard using the Graphics2D object
    public void draw(Graphics2D g2d){
        base = new Square(x1, y1, width, height, baseColor);
        side1 = new Circle(x1+50,y1,width,height,new Color(204, 0, 0)); //right
        side2 = new Circle(x1-50,y1,width,height,baseColor); //left

        wheel1 = new Circle(x1-(height/2.6), y1+height-10, height*0.6, height*0.6, Color.BLACK);
        wheel2 = new Circle(x1+width-(height/2.6), y1+height-10, height*0.6, height*0.6, Color.BLACK);

        wheel1.draw(g2d);
        wheel2.draw(g2d);
        side1.draw(g2d);
        side2.draw(g2d);
        base.draw(g2d);

        bearing1 = new Hexagon(x1-(height/12), y1+height+8, height/4, Color.LIGHT_GRAY);
        bearing2 = new Hexagon(x1+width-(height/12), y1+height+8, height/4, Color.LIGHT_GRAY);
        bearing1.draw(g2d);
        bearing2.draw(g2d);

        AffineTransform oldTransform = g2d.getTransform();
        int centerX = (int) ((base.x1 + side1.x1 + side2.x1) / 3);
        int centerY = (int) ((base.y1 + side1.y1 + side2.y1) / 3);
        g2d.translate(centerX, centerY);
        double angleInDegrees = -90;
        g2d.rotate(Math.toRadians(angleInDegrees));
        double scaleFactor = 1.8;
        g2d.scale(scaleFactor, scaleFactor);

        int arrowHeadX = -14;
        int arrowHeadY = -8;
        int[] xPoints = {arrowHeadX, arrowHeadX - 10, arrowHeadX + 10};
        int[] yPoints = {arrowHeadY, arrowHeadY + 30, arrowHeadY + 30};
        arrowHead = new Polygon(xPoints, yPoints, 3);
        g2d.setColor(arrowColor);
        g2d.fillPolygon(arrowHead);

        g2d.setTransform(oldTransform);

        arrowLine = new Square(x1+20, y1+15, width-5, height-30, arrowColor);
        arrowLine.draw(g2d);
    }

}
