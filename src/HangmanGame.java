import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hangman extends JPanel implements ActionListener{
    int boardWidth;
    int boardHeight;
    Image background= new ImageIcon("img/chalkboard.gif").getImage();

    Hangman(int boardWidth, int boardHeight){
        this.boardWidth= boardWidth;
        this.boardHeight= boardHeight;
        KeyBoard keyBoard= new KeyBoard();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background chalk board is showing..
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}