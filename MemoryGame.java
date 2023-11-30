import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame {
    final int columns = 4;
    final int rows = 3;
    ArrayList<JButton> buttonList = new ArrayList<JButton>(); // arraylist to hold buttons
    ArrayList<Color> colorsList = new ArrayList<Color>(); // arraylist to hold colors

    int match = 0; // how many matches we have
    JButton initialSelection; 
    int score = 0; // user score
    JMenu menu; // menu where score will be
   
    
    public MemoryGame() {
        super("Memory Game");

        GridLayout gridLayout = new GridLayout(rows, columns); // make the grid layout

        JMenuBar menuBar = new JMenuBar(); // create a menu bar
        menu = new JMenu("Score: " + score); // create a menu that holds the score
        JMenuItem jMenuItem = new JMenuItem("Restart Game"); // create a restart game option
        jMenuItem.addActionListener(e -> RestartGame()); // when the menu item is clicked, launches the restartGame logic
        menu.add(jMenuItem); // add the restart game text to the menu
        menuBar.add(menu); // add the menu to the menubar
        setJMenuBar(menuBar); // set the jmenu bar, referencing the menubar just created
        

        for(int i = 0; i < ROWS* COLUMNS; i++ ){ // for every button in the grid layout, add an action listener to each button
            JButton button = new JButton(); // to do this, create button for each iteration
            button.addActionListener(this::ButtonClicked); // add the action listener to that button
            buttonList.add(button); // add that button to the arraylist of buttons 
            add(button); // append button to the container JFrame
        }
        InitColorsList(); 
        setLayout(gridLayout); // set the layout of the JFrame to the grid layout
        setSize(900, 900); // set size of JFrame
        setLocation(500, 0); // set location of JFrame
        setVisible(true); // show the JFrame to the screen. If false... it won't show
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit the application when you close out of it
    }

    private void RestartGame() {
        for(int i = 0; i < buttonList.size(); i++ ){ // iterate through the buttonList
            JButton button = buttonList.get(i); // get the corresponding button for the iteration
            button.setBackground(null); // set the background back to default white
            button.setEnabled(true); // allow the user to click the button again to display the color
        } 

        score = 0; // initialize the score to 0
        menu.setText("Score: " + score); // update the score
        match = 0; // initialize the match to 0
        Collections.shuffle(colorsList); // shuffle the colors in colorsList so the user gets a new game 
    }

    

    private void ButtonClicked(ActionEvent actionEvent){
        JButton button = (JButton)actionEvent.getSource(); // 

        int index = buttonList.indexOf(button); // get the index of button in buttonList
        Color color = colorsList.get(index); // get the index of color in colorsList
        button.setBackground(color); // for each index of button, set the color to the same index in colorsList... so 0 index in buttonList will correspond to 0 index in colorsList, etc.

        if(initialSelection == null){ // if no button has been selected yet then we know this is the first button click
            initialSelection = button; // the initial selection is the button the user just selected
            button.setEnabled(false); // change that buttons "availability" to be disabled
        } else {
            if(initialSelection.getBackground().equals(button.getBackground())){ // if this buttons color equals the other buttons color
                // let user know of match
                button.setEnabled(false); // set the "availability" of this button to false to disable usage
                ++match; // increase number of matches by 1
                score += 10; // increase the score by 10

                if(match == 6){ // if there are 6 matches, then the board has been completely filled up with matching pairs of colors (alternatively, look to see if the setEnabled property is false on all buttons, but that is a slow process, where this is less dynamic but extremely fast)
                    JOptionPane.showMessageDialog(this, "Winner winner!"); // Let the user know they won in a message dialog box
                    RestartGame(); // Restart the game 
                }
            } else {
                // let user know there wasnt a match
                JOptionPane.showMessageDialog(this, "the colors dont match");

                // reset the buttons
                button.setEnabled(true); // the second button becomes available to click again
                button.setBackground(null); // background is reset to default 
                initialSelection.setEnabled(true); // the first button becomes available to click again
                initialSelection.setBackground(null); // reset background

                int newScore = score - 1; // if the user doesn't guess correctly, it should deduct 1 from their score. 
                score = newScore < 0 ? 0 : newScore; // if the new score is below 0, then 0 is their score. if the newscore is still above 0, then their old score - 1 is their newscore and score is set to the newscore.
            }

            menu.setText("Score: " + score); // update the score on the menu

            // reset the first selection to null
            initialSelection = null;

        }
        
    }

    private void InitColorsList() { // a list of all the colors usin Collections library
        Collections.addAll(colorsList, Color.CYAN, Color.CYAN, Color.MAGENTA, Color.MAGENTA, Color.PINK, Color.PINK, Color.BLACK, Color.BLACK,Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW );
        Collections.shuffle(colorsList);
    }
}
