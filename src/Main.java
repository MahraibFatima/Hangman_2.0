import javax.swing.*;

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

        Hangman hangman = new Hangman(boardWidth, boardHeight);

        frame.add(hangman);
        frame.pack();
        hangman.requestFocus();
    }

}