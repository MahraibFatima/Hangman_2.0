import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel implements ActionListener {
    private int score;
    int buttonWidth = 100;
    int buttonHeight = 50;

    public GameOverScreen(ImageIcon backgroundImg, JPanel container, CardLayout cardLayout, int finalScore) {
        this.score = finalScore;
        this.setLayout(new BorderLayout());

        // Background panel setup
        JPanel gameOverPanel = getJPanelBg(backgroundImg);

        // Input fields
        JPanel inputFields = getJPanelInput(container,cardLayout);
        gameOverPanel.add(inputFields, BorderLayout.NORTH);

        this.add(gameOverPanel, BorderLayout.CENTER);
    }

    private JPanel getJPanelInput(JPanel container, CardLayout cardLayout) {
        JPanel inputFields = new JPanel(new GridLayout(3, 1, 10, 10));
        inputFields.setOpaque(false);
        inputFields.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Game Over", SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Courier", Font.BOLD, 20));

        JLabel scoreLabel = new JLabel("Your Score is:", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Courier", Font.PLAIN, 16));

        Buttons.PlayButton scoreValue = new Buttons.PlayButton(String.valueOf(score), -(buttonWidth + 20), HEIGHT - (buttonHeight * 3), buttonWidth, buttonHeight, container, cardLayout);
        scoreValue.setVerticalAlignment(SwingConstants.CENTER);
        scoreValue.setFont(new Font("Courier", Font.BOLD, 18));
        scoreValue.setForeground(Color.BLACK);

        inputFields.add(titleLabel);
        inputFields.add(scoreLabel);
        inputFields.add(scoreValue);

        return inputFields;
    }

    private static JPanel getJPanelBg(ImageIcon backgroundImg) {
        JPanel gameOverPanel = new BackgroundPanel(backgroundImg.getImage());
        gameOverPanel.setLayout(new BorderLayout());
        return gameOverPanel;
    }

    static class BackgroundPanel extends JPanel {
        private final Image background;

        public BackgroundPanel(Image background) {
            this.background = background;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

