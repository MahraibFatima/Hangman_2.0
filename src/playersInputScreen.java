import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class playersInputScreen extends JPanel implements ActionListener{
    int boardWidth;
    int boardHeight;
    Image background= new ImageIcon("img/chalkboard.gif").getImage();

    playersInputScreen(int boardWidth, int boardHeight){
        this.boardWidth= boardWidth;
        this.boardHeight= boardHeight;

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background chalk board is showing.
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}