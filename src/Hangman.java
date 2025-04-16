import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Hangman extends JPanel implements ActionListener, KeyListener{
    int boardWidth;
    int boardHeight;

    Hangman(int boardWidth, int boardHeight){
        this.boardWidth= boardWidth;
        this.boardHeight= boardHeight;

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.darkGray);
        addKeyListener(this);
        setFocusable(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }

}
