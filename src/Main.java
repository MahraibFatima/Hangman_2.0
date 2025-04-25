import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman";
        final ImageIcon chalkBoard = new ImageIcon("img/chalkboard.gif");
        final ImageIcon start_screen_hangman= new ImageIcon("img/start_screen_bg.gif");

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
        StartPanel startPanel = new StartPanel(WIDTH, HEIGHT, start_screen_hangman, container, cardLayout);
        container.add(startPanel, "1");

        //players input screen
        playersInputScreen playersInput = new playersInputScreen(WIDTH, HEIGHT, chalkBoard, container, cardLayout);
        container.add(playersInput, "2");

        //HangmanGame hangman= new HangmanGame(WIDTH, HEIGHT);
        //container.add(hangman);

        //players names input screen


        cardLayout.show(container, "1");


        screen.setVisible(true);
    }
}