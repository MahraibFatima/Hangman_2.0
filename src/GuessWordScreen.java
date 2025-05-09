import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;

public class GuessWordScreen extends JPanel implements ActionListener, KeyListener {
    JTextField guessWord_field;
    JButton submitButton;
    JButton backButton;
    JPanel container;
    String player1Name;
    String player2Name;
    CardLayout cardLayout;
    public GuessWordScreen(ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        this.container= container;
        this.cardLayout= cardLayout;

        // Background panel setup
        JPanel background = Background.setBackgroundPanel(backgroundImg);

        // Input fields
        JPanel input_fields = getJPanel_input();
        background.add(input_fields, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setOpaque(false);

        // Create and add buttons
        this.submitButton = new JButton("Submit");
        this.backButton = new JButton("Back");

        // Style buttons
        Styles.getStyleButton(submitButton);
        Styles.getStyleButton(backButton);

        // Add action listeners later
//        Map<String, String> playerNames = (Map<String, String>) container.getClientProperty("playerNames");

        this.player1Name = GameState.getPlayer1();
        this.player2Name = GameState.getPlayer2();
        System.out.println(player1Name + " " + player2Name);
        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);

        submitButton.addActionListener(this);
        backButton.addActionListener(this);
        background.add(buttonPanel, BorderLayout.SOUTH);

        // Add to this main panel
        this.add(background, BorderLayout.CENTER);
    }

    private JPanel getJPanel_input() {
        JPanel input_fields = new JPanel(new GridLayout(5, 1, 10, 10));
        input_fields.setOpaque(false);
        input_fields.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String label= player1Name + " enter word for " + player2Name;
        JLabel inputNames = new JLabel(label, SwingConstants.CENTER);
        Font font = new Font("Courier", Font.BOLD, 20);
        inputNames.setFont(font);

        this.guessWord_field = Styles.getJTextFieldStyle();
        guessWord_field.addKeyListener(this);

        input_fields.add(inputNames);
        input_fields.add(guessWord_field);

        return input_fields;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            submitButton.doClick();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String guessWord = guessWord_field.getText().trim();

            if (guessWord.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Word for guess",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            } else {
                //player names storage pending
                if (this.cardLayout != null && this.container != null) {
                    cardLayout.show(container, "4"); // Switch to game screen
                }
            }
        }
        else if (e.getSource() == backButton) {
            // Return to previous screen
            if (this.cardLayout != null && this.container != null) {
                cardLayout.show(container, "2"); // Switch back to start screen
            }
        }
    }
    // unused
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}