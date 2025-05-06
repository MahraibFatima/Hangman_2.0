import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman";
        int finalScore=-1;
        final ImageIcon chalkBoard = new ImageIcon("img/chalkboard.gif");
        final ImageIcon hangman_screen= new ImageIcon("img/start_screen_bg.gif");
        final ImageIcon hangman_without_text= new ImageIcon("img/Gallow_without_text.gif");

        JFrame screen = new JFrame();
        CardLayout cardLayout = new CardLayout();
        screen.setSize(new Dimension(WIDTH, HEIGHT));
        screen.setTitle(TITLE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        //screen.setDefaultCloseOperation(screen.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);
        screen.add(container);

        //start screen
        StartPanel startPanel = new StartPanel(WIDTH, HEIGHT, hangman_screen, container, cardLayout);
        container.add(startPanel, "1");

        //players input screen
        playersInputScreen playersInput = new playersInputScreen(chalkBoard, container, cardLayout);
        container.add(playersInput, "2");

        //Hangman main game screen
        HangmanGame hangman= new HangmanGame(chalkBoard);
        container.add(hangman, "3");

        //game over screen
        GameOverScreen gameOver= new GameOverScreen(hangman_without_text, container, cardLayout, finalScore);
        container.add(gameOver, "4");


        cardLayout.show(container, "1");

        screen.setVisible(true);
    }
}