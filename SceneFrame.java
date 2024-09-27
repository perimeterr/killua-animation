/** The SceneFrame class is the class that sets up the base frame for the program and creates the SceneCanvas object.
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

import javax.swing.*;

public class SceneFrame {
    
    private JFrame frame;
    private SceneCanvas sc;

    // Constructor creates a JFrame and SceneCanvas
    public SceneFrame() {
        frame = new JFrame();
        sc = new SceneCanvas();
    }

    // Sets up the required operations to make the program visible
    public void setUpGUI() {
        frame.setTitle("Midterm Project - Aguilar - Paderna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sc);
        sc.setUpListeners();
        sc.setFocusable(true);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
