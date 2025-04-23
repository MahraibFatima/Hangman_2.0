import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman";
        final ImageIcon backgroundImg = new ImageIcon("img/start_screen_bg.gif");

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


        StartPanel startPanel = new StartPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout);

        container.add(startPanel, "1");

        screen.setVisible(true);
    }
}