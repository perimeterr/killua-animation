/** The SceneCanvas class is the class that compiles all the shapes needed to create the full animated scene. It also involves the methods for animating all the shapes.
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

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class SceneCanvas extends JComponent{
    private int width = 800;
    private int height = 600;

    private ArrayList<DrawingObject> shapes;

    private Color skyColor1, skyColor2;

    private Timer killuaTimer, logoTimer;

    private Killua killua;
    private Square road;
    private Cloud c1, c2, c3;
    private Rock r1, r2;
    private Logo HXH;

    // Constructor initializes all the shapes for the scene
    public SceneCanvas() {
        this.setPreferredSize(new Dimension(width,height));

        skyColor1 = new Color(136,195,247);
        skyColor2 = new Color(66,135,247);

        shapes = new ArrayList<DrawingObject>();

        HXH = new Logo(700,50,30);
        road = new Square(0,420,800,180,Color.DARK_GRAY);
        killua = new Killua(430,170,60);
        c1 = new Cloud(-100,50,75, Color.WHITE); // left
        c2 = new Cloud(250,74,90, Color.WHITE); // middle
        c3 = new Cloud(700,100,80,Color.WHITE); //right
        r1 = new Rock(10,450,10, Color.GRAY); // left
        r2 = new Rock(600,450,15, Color.GRAY); // right

        shapes.add(road);
        shapes.add(c1);
        shapes.add(c2);
        shapes.add(c3);
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(killua);
        shapes.add(HXH);
    }

    // Method for overall drawing of all shapes
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHints(rh);

        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        GradientPaint gp = new GradientPaint(0,0,skyColor1,0,600,skyColor2,true);
        g2d.setPaint(gp);
        g2d.fill(bg);

        for (DrawingObject s : shapes) {
            s.draw(g2d);
        }

    }

    // Overall method for manipulating and animating all the needed shapes when Killua moves to the right
    private void moveRight() {
        killua.moveRight();
        killua.bounce();
        for (DrawingObject s: shapes) {
            if (s instanceof Cloud) {
                s.moveLeft();
                s.decreaseVelocity();
                if (s.getX() < -(s.getSize() * 2.7)) s.setX(1000);
            } else if (s instanceof Rock) {
                s.moveLeft();
                s.decreaseVelocity();
                if (s.getX() < -50) s.setX(1000);
            }
        }
        repaint();
    }

    // Overall method for manipulating and animating all the needed shapes when Killua moves to the left
    private void moveLeft() {
        killua.moveLeft();
        killua.bounce();
        for (DrawingObject s: shapes) {
            if (s instanceof Cloud) {
                s.moveRight();
                s.increaseVelocity();
                if (s.getX() > 800) s.setX(-380);
            } else if (s instanceof Rock) {
                s.moveRight();
                s.increaseVelocity();
                if (s.getX() > 850) s.setX(-200);
            }
        }
        repaint();
    }

    // Sets up the keylisteners and actionlisteners needed to animate the scene
    public void setUpListeners() {

        // KeyListener for checking the keyboard input to make Killua move right or left
        KeyListener kl = new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 65 || key == 37) {
                    moveLeft();
                } else if (key == 68 || key == 39) {
                    moveRight();
                }
                killuaTimer.start();
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                for (DrawingObject s : shapes) {
                    s.resetVelocity();
                }
                killua.resetKeyFrame();
                killuaTimer.stop();
            }
        };
        this.addKeyListener(kl);

        // ActionListener for continuous animation of objects by repeatedly moving to the next keyframe
        ActionListener killuaAnimation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                killua.nextKeyFrame();
            }
        };
        killuaTimer = new Timer(150,killuaAnimation);
        killuaTimer.setRepeats(true);

        // ActionListener for animating the logo
        ActionListener logoAnimation = new ActionListener() {
            boolean big = false;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (HXH.getSize() < 40 && !big) {
                    HXH.increaseSize();
                    repaint();
                } else if (HXH.getSize() == 40) {
                    big = true;
                }
                if (HXH.getSize() > 30 && big) {
                    HXH.decreaseSize();
                    repaint();
                } else if (HXH.getSize() == 30) {
                    big = false;
                }
            }
        };
        logoTimer = new Timer(75,logoAnimation);
        logoTimer.setRepeats(true);
        logoTimer.start();
    }

}