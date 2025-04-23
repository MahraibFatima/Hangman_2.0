import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hangman extends JPanel implements ActionListener{
    int boardWidth;
    int boardHeight;

    Hangman(int boardWidth, int boardHeight){
        this.boardWidth= boardWidth;
        this.boardHeight= boardHeight;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = new ImageIcon("C:/path/to/image.jpg").getImage();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}