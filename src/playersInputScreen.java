import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class playersInputScreen extends JPanel implements ActionListener {

    public playersInputScreen(int boardWidth, int boardHeight, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());

        // Background panel setup
        JPanel backgroundWithKeyboard = getJPanelBg(backgroundImg);

        // Input fields
        JPanel input_fields = getJPanel_input();
        backgroundWithKeyboard.add(input_fields, BorderLayout.NORTH);

        // Add to this main panel
        this.add(backgroundWithKeyboard, BorderLayout.CENTER);
    }

    private static JPanel getJPanel_input() {
        JPanel input_fields = new JPanel(new GridLayout(5, 1, 10, 10));
        input_fields.setOpaque(false);
        input_fields.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel inputNames = new JLabel("Enter your names here", SwingConstants.CENTER);
        Font font = new Font("Courier", Font.BOLD, 20);
        inputNames.setFont(font);

        JLabel player1_label = new JLabel("Player 1:");
        JTextField playerName1_field = getJTextField();

        JLabel player2_label = new JLabel("Player 2:");
        JTextField playerName2_field = getJTextField();

        input_fields.add(inputNames);
        input_fields.add(player1_label);
        input_fields.add(playerName1_field);
        input_fields.add(player2_label);
        input_fields.add(playerName2_field);

        return input_fields;
    }

    private static JTextField getJTextField() {
        JTextField field = new JTextField(5);
        field.setForeground(Color.BLACK);
        field.setOpaque(true);
        field.setFont(new Font("SansSerif", Font.PLAIN, 20));
        field.setBackground(new Color(255, 255, 255, 200));
        return field;
    }

    private static JPanel getJPanelBg(ImageIcon backgroundImg) {
        JPanel backgroundWithKeyboard = new BackgroundPanel(backgroundImg.getImage());
        backgroundWithKeyboard.setLayout(new BorderLayout());

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setOpaque(false);

        KeyBoard keyBoard = new KeyBoard();
        keyBoard.displayButtons(keyboardPanel);

        backgroundWithKeyboard.add(keyboardPanel, BorderLayout.SOUTH);
        return backgroundWithKeyboard;
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
        // Implement logic later
    }
}
