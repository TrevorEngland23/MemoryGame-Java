import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame {

    ArrayList<JButton> buttonList =  new ArrayList<JButton>(); // create an arraylist of buttons
    final int columns = 4;
    final int rows = 3;
    ArrayList<Color> colorsList = new ArrayList<Color>();

    int match = 0;
    JButton initialSelection;
    

    // ctor(s)
    public MemoryGame() {
        super("Memory Game");

        // make a grid layout
        GridLayout gridLayout = new GridLayout(rows, columns); // rows, columns

        for(int i = 0; i < rows * columns; i++){
            JButton button = new JButton();
            button.addActionListener(e -> buttonClicked(e)); // alternatively can use (this::buttonClicked)
            buttonList.add(button);
            add(button);
        }

        // call the method initColorsList
        initColorsList();   
        // grid layout
        setLayout(gridLayout);
        // set size of panel
        setSize(900,900);
        // set location panel pops on screen
        setLocation(500,0);
        // make it visible
        setVisible(true);
        // program exits when user closes the application
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
}

    private void buttonClicked(ActionEvent event){
        JButton button = (JButton)(event.getSource());

        // get the index of the current button clicked
        int index = buttonList.indexOf(button);
        // set the corresponding index from colorsList to be the index of button
        Color color = colorsList.get(index);

        // set background color of buttons to red
        button.setBackground(color);

        if(initialSelection == null){
            // this is the first button click
            initialSelection = button;
            button.setEnabled(false);
        } else{

        if(initialSelection.getBackground().equals(button.getBackground())){
            // let user know of match
            button.setEnabled(false);
    
        } else {
            // reset the buttons

            // let user know there wasn't a match
            JOptionPane.showMessageDialog(this, "The colors don't match.");
            button.setEnabled(true);
            button.setBackground(null);
            initialSelection.setEnabled(true);
            initialSelection.setBackground(null);
        }
            initialSelection = null;
        
    }


    }

    private void initColorsList(){

        // shuffle the buttons / colors
        Collections.addAll(colorsList, Color.RED, Color.RED, 
                                       Color.BLUE, Color.BLUE, 
                                       Color.ORANGE,Color.ORANGE, 
                                       Color.MAGENTA, Color.MAGENTA, 
                                       Color.CYAN, Color.CYAN, 
                                       Color.PINK, Color.PINK);

        Collections.shuffle(colorsList);
    }
    }


