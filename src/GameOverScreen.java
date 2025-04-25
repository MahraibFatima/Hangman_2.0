import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel implements ActionListener {
    int score= -1;
    GameOverScreen(int boardWidth, int boardHeight, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout){
        this.setLayout(new BorderLayout());

        // Background panel setup
        JPanel gameOverPanel = getJPanelBg(backgroundImg);

        // Input fields
        JPanel input_fields = getJPanel_input();
        gameOverPanel.add(input_fields, BorderLayout.NORTH);

        this.add(gameOverPanel, BorderLayout.CENTER);

    }

    private JPanel getJPanel_input() {
        JPanel input_fields = new JPanel(new GridLayout(3, 1, 10, 10));
        input_fields.setOpaque(false);
        input_fields.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel inputNames = new JLabel("Game Over", SwingConstants.CENTER);
        inputNames.setForeground(Color.RED);
        Font font = new Font("Courier", Font.BOLD, 20);
        inputNames.setFont(font);

        JLabel player1_label = new JLabel("Your Score is: ", SwingConstants.CENTER);
        JLabel playerScore= new JLabel();
        playerScore.setText(String.valueOf(score));
        playerScore.setHorizontalAlignment(SwingConstants.CENTER);


        input_fields.add(inputNames);
        input_fields.add(player1_label);
        input_fields.add(playerScore);
        return input_fields;
    }

    private static JTextField getJTextField() {
        JTextField field = new JTextField(5);
        field.setForeground(Color.BLACK);
        field.setOpaque(true);
        field.setFont(new Font("SansSerif", Font.BOLD, 20));
        field.setBackground(new Color(255, 255, 255, 200));
        return field;
    }

    private static JPanel getJPanelBg(ImageIcon backgroundImg) {
        JPanel gameOverPanel = new GameOverScreen.BackgroundPanel(backgroundImg.getImage());
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
