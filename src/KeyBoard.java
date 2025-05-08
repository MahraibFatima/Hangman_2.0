import javax.swing.*;
import java.awt.*;

public class KeyBoard {
    public static void displayButtons(JPanel keyboardPanel) {
        keyboardPanel.setLayout(new GridBagLayout());
        keyboardPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // Reduced padding between buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Q - P
        gbc.gridy = 0;
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row1.setOpaque(false);
        for (char c : "qwertyuiop".toCharArray()) {
            row1.add(new KeyBoardButtons(c));
        }
        keyboardPanel.add(row1, gbc);

        // Row 2: A - L
        gbc.gridy = 1;
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row2.setOpaque(false);
        row2.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0)); // slight left indent
        for (char c : "asdfghjkl".toCharArray()) {
            row2.add(new KeyBoardButtons(c));
        }
        keyboardPanel.add(row2, gbc);

        // Row 3: Z - M
        gbc.gridy = 2;
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row3.setOpaque(false);
        row3.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // reduced indent
        for (char c : "zxcvbnm".toCharArray()) {
            row3.add(new KeyBoardButtons(c));
        }
        keyboardPanel.add(row3, gbc);
    }
}
class KeyBoardButtons extends JButton {
    private final char value;

    public KeyBoardButtons(char value) {
        this.value = value;

        this.setFocusable(false);
        this.setText(String.valueOf(this.value).toUpperCase());
    }

    public char getValue() {
        return this.value;
    }
}