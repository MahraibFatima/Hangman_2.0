import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class playersInputScreen extends JPanel implements ActionListener {
    JTextField playerName1_field;
    JTextField playerName2_field;
    JButton submitButton;
    JButton backButton;
    JPanel container;
    CardLayout cardLayout;
    public playersInputScreen(ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        this.container= container;
        this.cardLayout= cardLayout;

        // Background panel setup
        JPanel backgroundWithKeyboard = Background.setBgWithKeyBoard(backgroundImg);

        // Input fields
        JPanel input_fields = getJPanel_input();
        backgroundWithKeyboard.add(input_fields, BorderLayout.NORTH);

        // Keyboard in the center
        JPanel keyboardPanel = new JPanel();
        KeyBoard.displayButtons(keyboardPanel);
        contentPanel.add(keyboardPanel, BorderLayout.CENTER);

        // Button panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setOpaque(false);

        // Create and add buttons
        this.submitButton = new JButton("Submit");
        this.backButton = new JButton("Back");

        // Style buttons
        Styles.getStyleButton(submitButton);
        Styles.getStyleButton(backButton);

        // Add action listeners later

        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);

        submitButton.addActionListener(this);
        backButton.addActionListener(this);
        backgroundWithKeyboard.add(buttonPanel, BorderLayout.SOUTH);

        // Add to this main panel
        this.add(backgroundWithKeyboard, BorderLayout.CENTER);
    }

    private JPanel getJPanel_input() {
        JPanel input_fields = new JPanel(new GridLayout(5, 1, 10, 10));
        input_fields.setOpaque(false);
        input_fields.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel inputNames = new JLabel("Enter your names here", SwingConstants.CENTER);
        Font font = new Font("Courier", Font.BOLD, 20);
        inputNames.setFont(font);

        JLabel player1_label = new JLabel("Player 1:");
        this.playerName1_field = Styles.getJTextFieldStyle();


        JLabel player2_label = new JLabel("Player 2:");
        this.playerName2_field = Styles.getJTextFieldStyle();

        input_fields.add(inputNames);
        input_fields.add(player1_label);
        input_fields.add(playerName1_field);
        input_fields.add(player2_label);
        input_fields.add(playerName2_field);

        return input_fields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String player1 = playerName1_field.getText().trim();
            String player2 = playerName2_field.getText().trim();

            if (player1.isEmpty() || player2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter names for both players",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            } else {
                //player names storage pending
                if (this.cardLayout != null && this.container != null) {
                    cardLayout.show(container, "3"); // Switch to game screen
                }
            }
        }
        else if (e.getSource() == backButton) {
            // Return to previous screen
            if (this.cardLayout != null && this.container != null) {
                cardLayout.show(container, "1"); // Switch back to start screen
            }
        }
    }
}