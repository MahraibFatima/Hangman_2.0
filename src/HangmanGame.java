import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HangmanGame extends JPanel implements ActionListener, KeyboardListener {
    private static JButton chanceLeftButton;
    private static JTextField guessWordField;
    private static JLabel imageLabel;
    private final List<JButton> keyboardButtons = new ArrayList<>();
    private String secretWord = "JAVA"; // Example word - will load this dynamically
    private StringBuilder currentGuess = new StringBuilder();
    private int remainingGuesses = 6;
    private final ImageIcon[] hangmanImages = new ImageIcon[7];

    public HangmanGame(ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        GameState gameState = (GameState) container.getClientProperty("gameState");
        this.secretWord = gameState.getSecretWord();
        // Initialize hangman images
        for (int i = 0; i <= 6; i++) {
            hangmanImages[i] = new ImageIcon("img/Gallows" + i + ".gif");
        }

        // Initialize current guess with underscores
        currentGuess.append("_ ".repeat(secretWord.length()));

        // Background panel with keyboard at SOUTH
        JPanel background = Background.setBackgroundPanel(backgroundImg);

        // Create center content
        JPanel centerPanel = createCenterPanel();
        background.add(centerPanel, BorderLayout.CENTER);

        // Create keyboard panel
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setOpaque(false);
        KeyBoard.displayButtons(keyboardPanel, this);

        // Add action listeners to keyboard buttons
        for (Component comp : keyboardPanel.getComponents()) {
            if (comp instanceof JPanel) {
                for (Component button : ((JPanel)comp).getComponents()) {
                    if (button instanceof JButton) {
                        ((JButton)button).addActionListener(this);
                        keyboardButtons.add((JButton)button);
                    }
                }
            }
        }

        background.add(keyboardPanel, BorderLayout.SOUTH);
        this.add(background, BorderLayout.CENTER);

        // Initialize game state
        updateGameDisplay();
    }
    private static JPanel chances_panel() {
        JPanel guessWord_panel = new JPanel(new GridLayout(8, 1, 10, 10));
        guessWord_panel.setOpaque(false);
        guessWord_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel chancesLeft_label = new JLabel("Chances Left", SwingConstants.LEFT);
        chancesLeft_label.setFont(font);

        chanceLeftButton = new JButton();
        chanceLeftButton.setText("6");
        chanceLeftButton.setEnabled(false);

        guessWord_panel.add(chancesLeft_label);
        guessWord_panel.add(chanceLeftButton);

        return guessWord_panel;
    }

    private static JPanel imageToEast() {
        imageLabel = new JLabel(new ImageIcon("img/Gallows0.gif")); // Initial image
        JPanel imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        imagePanel.add(imageLabel);
        return imagePanel;
    }

    private static JPanel guessWord_panel() {
        JPanel guessWord_panel = new JPanel(new GridLayout(2, 1, 10, 10));
        guessWord_panel.setOpaque(false);
        guessWord_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel guessWord_label = new JLabel("Guess Word ", SwingConstants.LEFT);
        guessWord_label.setFont(font);

        guessWordField = Styles.getJTextFieldStyle();
        guessWordField.setEditable(false);

        guessWord_panel.add(guessWord_label);
        guessWord_panel.add(guessWordField);

        return guessWord_panel;
    }

    private JPanel createCenterPanel() {
        // --- LEFT SIDE: Chances Left ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.add(chances_panel(), BorderLayout.CENTER);

        // --- RIGHT SIDE: Image Panel ---
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(imageToEast(), BorderLayout.CENTER);

        // --- CENTER SIDE: guessWord Panel ---
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(guessWord_panel(), BorderLayout.CENTER);

        // --- CENTER PANEL: Contains left and right ---
        JPanel mainCenterPanel = new JPanel(new BorderLayout());
        mainCenterPanel.setOpaque(false);
        mainCenterPanel.add(leftPanel, BorderLayout.WEST);
        mainCenterPanel.add(rightPanel, BorderLayout.EAST);
        mainCenterPanel.add(centerPanel, BorderLayout.SOUTH);

        return mainCenterPanel;
    }

    private void processGuess(char guessedLetter) {
        boolean correctGuess = false;
        guessedLetter = Character.toUpperCase(guessedLetter);

        // Check if the letter is in the secret word
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedLetter) {
                // Update the current guess display
                currentGuess.setCharAt(i * 2, guessedLetter);
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            remainingGuesses--;
            updateHangmanImage();
        }

        updateGameDisplay();
        checkGameEnd();
    }

    private void updateHangmanImage() {
        int imageIndex = 6 - remainingGuesses; // Assuming 6 total guesses
        if (imageIndex >= 0 && imageIndex < hangmanImages.length) {
            imageLabel.setIcon(hangmanImages[imageIndex]);
        }
    }

    private void updateGameDisplay() {
        chanceLeftButton.setText(String.valueOf(remainingGuesses));
        guessWordField.setText(currentGuess.toString());
    }

    private void checkGameEnd() {
        if (!currentGuess.toString().contains("_")) {
            // Player won
            JOptionPane.showMessageDialog(this, "Congratulations! You won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        } else if (remainingGuesses <= 0) {
            // Player lost
            JOptionPane.showMessageDialog(this, "Game Over! The word was: " + secretWord, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
    }

    private void resetGame() {
        // Reset game state
        remainingGuesses = 6;
        currentGuess = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            currentGuess.append("_ ");
        }

        // Reset keyboard buttons
        for (JButton button : keyboardButtons) {
            button.setEnabled(true);
        }

        // Reset hangman image
        imageLabel.setIcon(hangmanImages[0]);

        updateGameDisplay();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton clickedButton) {
            String letter = clickedButton.getText();

            // Disable the clicked button
            clickedButton.setEnabled(false);

            // Process the guess
            processGuess(letter.charAt(0));
        }
    }
    @Override
    public void setKeyboardButtonsMap(Map<Character, KeyBoard.KeyBoardButtons> map) {
    }
}