import javax.swing.*;
import java.awt.*;

public static void main(String[] args) {

    final int WIDTH = 800;
    final int HEIGHT = 600;
    final String TITLE = "Hangman";
    final ImageIcon chalkBoard = new ImageIcon("img/chalkboard.gif");
    final ImageIcon hangman_screen = new ImageIcon("img/start_screen_bg.gif");
    final ImageIcon hangman_without_text = new ImageIcon("img/Gallow_without_text.gif");

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

    // In your main method:
    GameState gameState = new GameState();
    container.putClientProperty("gameState", gameState);
    //start screen
    StartScreen startScreen = new StartScreen(hangman_screen, container, cardLayout);
    container.add(startScreen, "1");

    //players input screen
    PlayersInputScreen playersInput = new PlayersInputScreen(chalkBoard, container, cardLayout);
    container.add(playersInput, "2");

    GuessWordScreen guessWordScreen = new GuessWordScreen(chalkBoard, container, cardLayout);
    container.add(guessWordScreen, "3");

    //Hangman main game screen
    HangmanGame hangman = new HangmanGame(chalkBoard, container, cardLayout);
    container.add(hangman, "4");
    //game over screen
    int finalScore = 0;
    GameOverScreen gameOver = new GameOverScreen(hangman_without_text, container, cardLayout, finalScore);
    container.add(gameOver, "5");


    cardLayout.show(container, "1");

    screen.setVisible(true);
}