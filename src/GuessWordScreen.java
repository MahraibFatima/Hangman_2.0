import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessWordScreen extends JPanel implements ActionListener {
    JTextField guessWord_field;
    JButton submitButton;
    JButton backButton;
    JPanel container;
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

        JLabel inputNames = new JLabel("Enter guess word", SwingConstants.CENTER);
        Font font = new Font("Courier", Font.BOLD, 20);
        inputNames.setFont(font);

        this.guessWord_field = Styles.getJTextFieldStyle();


        input_fields.add(inputNames);
        input_fields.add(guessWord_field);

        return input_fields;
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
}