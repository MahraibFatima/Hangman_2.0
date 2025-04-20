import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int boardWidth= 600;
        int boardHeight= 600;

        JFrame frame= new JFrame("Hangman");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon originalIcon = new ImageIcon("C:/Users/PMLS/Documents/imp-docs/raw/pic/luca-micheli-ruWkmt3nU58-unsplash.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(boardWidth, boardHeight, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));

        frame.setContentPane(background);
        background.setLayout(new BorderLayout());
        
        Hangman hangman = new Hangman(boardWidth, boardHeight);
        background.add(hangman);

        frame.setVisible(true);
        hangman.requestFocus();

    }

}