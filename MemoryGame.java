import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MemoryGame extends JFrame {

    ArrayList<JButton> buttonList =  new ArrayList<JButton>(); // create an arraylist of buttons
    final int columns = 4;
    final int rows = 3;
    ArrayList<Color> colorsList = new ArrayList<Color>();
    

    // ctor(s)
    public MemoryGame() {
        super("Memory Game");

        // make a grid layout
        GridLayout gridLayout = new GridLayout(rows, columns); // rows, columns

        for(int i = 0; i < rows * columns; i++){
            JButton button = new JButton();
            buttonList.add(button);
            add(button);
        }

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

    private void initColorsList(){
        colorsList.add(Color.RED);
        colorsList.add(Color.RED);
        colorsList.add(Color.BLUE);
        colorsList.add(Color.BLUE);
        colorsList.add(Color.ORANGE);
        colorsList.add(Color.ORANGE);
        colorsList.add(Color.MAGENTA);
        colorsList.add(Color.MAGENTA);
        colorsList.add(Color.CYAN);
        colorsList.add(Color.CYAN);
        colorsList.add(Color.PINK);
        colorsList.add(Color.PINK);
    }
    }


