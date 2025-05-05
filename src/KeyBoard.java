import javax.swing.*;
import java.awt.*;

public class KeyBoard extends JButton {

    private final KeyBoardButtons[] buttons = new KeyBoardButtons[26];

    public KeyBoard() {

    }

    public void displayButtons(JPanel keyboardPanel) {
        keyboardPanel.setLayout(new BoxLayout(keyboardPanel, BoxLayout.Y_AXIS));
        keyboardPanel.setOpaque(false); // let background show through

        // Row 1: Q - P
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        row1.setOpaque(false);
        for (char c : "qwertyuiop".toCharArray()) {
            row1.add(new KeyBoardButtons(c));
        }

        // Row 2: A - L
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        row2.setOpaque(false);
        row2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // slight left indent
        for (char c : "asdfghjkl".toCharArray()) {
            row2.add(new KeyBoardButtons(c));
        }

        // Row 3: Z - M
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        row3.setOpaque(false);
        row3.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0)); // more indent
        for (char c : "zxcvbnm".toCharArray()) {
            row3.add(new KeyBoardButtons(c));
        }

        // Add rows to main panel
        keyboardPanel.add(row1);
        keyboardPanel.add(row2);
        keyboardPanel.add(row3);
    }


    public void disableKeyboard() {
        for (KeyBoardButtons button : this.buttons) {
            button.setEnabled(false);
        }
    }

    private KeyBoardButtons[] getButtons() {

        return this.buttons;
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