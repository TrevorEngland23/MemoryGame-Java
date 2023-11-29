import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MemoryGame extends JFrame {

    ArrayList<JButton> buttonList =  new ArrayList<JButton>(); // create an arraylist of buttons
    final int columns = 4;
    final int rows = 3;
    

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

        setLayout(gridLayout);
        setSize(900,900);
        setLocation(500,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // program exits when user closes the application
}
    }


