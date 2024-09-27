/** The SceneStarter class is the main class for the program. It instantiates the object of the SceneFrame class, allowing the entire scene to display and work. It also prints a welcome message to the users.
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

public class SceneStarter {
    public static void main(String[] args) {
        SceneFrame sf = new SceneFrame();
        sf.setUpGUI();
        System.out.println("Welcome to Hunter X Hunter Killua's skateboard practice!");
        System.out.println("Press A or the Left Arrow Key to make Killua move left!");
        System.out.println("Press D or the Right Arrow Key to make Killua move right!");
    }
}