/** The DrawingObject class is an abstract class that serves as the parent class of all shapes used in the program. It consists of all the required fields to create the shapes and of all the methods needed to manipulate said shapes.
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

public abstract class DrawingObject {
    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;
    protected double cx;
    protected double cy;
    protected double width;
    protected double height;
    protected double size;
    protected Color baseColor;
    protected BasicStroke thickness;

    protected static int keyFrame = 0;
    final int MAX_KEYFRAMES = 7;

    protected int velocity = 1;

    /** Constructor for initializing a shape that only requires the x-coordinate, y-coordinate, and size
        @param x is the shape's x-coordinate
        @param y is the shape's y-coordinate
        @param s is the shape's size
    **/
    public DrawingObject(double x, double y, double s) {
        x1 = x;
        y1 = y;
        size = s;
    }

    /** Constructor for initializing a shape that requires the x-coordinate, y-coordinate, size, and color
        Used for perfect circles, hexagons, and pentagons
        @param x is the shape's x-coordinate
        @param y is the shape's y-coordinate
        @param s is the shape's size
        @param c is the shape's color
    **/
    public DrawingObject(double x, double y, double s, Color c) {
        x1 = x;
        y1 = y;
        size = s;
        baseColor = c;
    }

    /** Constructor for initializing a shape that requires the x-coordinate, y-coordinate, width and height, and color
        Used for ellipses and rectangles
        @param x is the shape's x-coordinate
        @param y is the shape's y-coordinate
        @param w is the shape's width
        @param h is the shape's height
        @param c is the shape's color
    **/
    public DrawingObject(double x, double y, double w, double h, Color c){
        x1 = x;
        y1 = y;
        width = w;
        height = h;
        baseColor = c;
    }

    /** Constructor for initializing a shape that requires two x- and y- coordinates, color, and thickness
        Used for lines
        @param x1 is the shape's starting x-coordinate
        @param y1 is the shape's starting y-coordinate
        @param x2 is the shape's ending x-coordinate
        @param y2 is the shape's ending y-coordinate
        @param s is the shape's thickness
        @param c is the shape's color
    **/
    public DrawingObject(double x1, double y1, double x2, double y2, int s, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        baseColor = c;
        thickness = new BasicStroke(s);

    }

    // Default method for drawing all objects, varies depending on shape
    public void draw(Graphics2D g2d) {}

    // Moves the shape to the right by increasing the x-coordinate with respect to the object's velocity
    public void moveRight() {
        x1 += 10 + (0.25 * velocity);
    }

    // Moves the shape to the left by decreasing the x-coordinate with respect to the object's velocity
    public void moveLeft() {
        x1 -= 10 - (0.25 * velocity);
    }

    // Increases the object's velocity, allows for acceleration when moving to the right
    public void increaseVelocity() {
        velocity += 5;
    }   

    // Decreases the object's velocity, allows for acceleration when moving to the left
    public void decreaseVelocity() {
        velocity -= 5;
    }

    // Resets the object's velocity to the default value
    public void resetVelocity() {
        velocity = 1;
    }

    // Resets the object's keyframe
    public void resetKeyFrame() {
        keyFrame = 0;
    }
    
    // Moves to the next keyframe, used for animating
    public void nextKeyFrame() {
        if (keyFrame < MAX_KEYFRAMES) {
            keyFrame += 1;
        } else {
            keyFrame = 0;
        }
    }

    /**
        Gets the shape's x-coordinate
        @return the x-coordinate
    **/
    public double getX() {
        return x1;
    }

    /**
        Gets the shape's y-coordinate
        @return the y-coordinate
    **/
    public double getY() {
        return y1;
    }

    /**
        Gets the shape's size
        @return the size
    **/
    public double getSize() {
        return size;
    }

    /**
        Changes the shape's x-coordinate
        @param x is the new x-coordinate
    **/
    public void setX(double x) {
        x1 = x;
    }

    /**
        Changes the shape's y-coordinate
        @param x is the new y-coordinate
    **/
    public void setY(double y) {
        y1 = y;
    }
}
