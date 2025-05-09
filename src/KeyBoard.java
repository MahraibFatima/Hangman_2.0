import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

//public class KeyBoard {
//    public static void displayButtons(JPanel keyboardPanel, KeyboardListener listener) {
//        // ... existing code ...
//        listener.setKeyboardButtonsMap(buttonsMap);
//    }
//}
public class KeyBoard {
    private static Map<Character, KeyBoardButtons> buttonsMap = new HashMap<>();
    private Map<Character, KeyBoardButtons> keyboardButtonsMap;

    public static void displayButtons(JPanel keyboardPanel, KeyboardListener listener) {
        keyboardPanel.setLayout(new GridBagLayout());
        keyboardPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Q - P
        gbc.gridy = 0;
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row1.setOpaque(false);
        for (char c : "qwertyuiop".toCharArray()) {
            KeyBoardButtons button = new KeyBoardButtons(c);
            row1.add(button);
            buttonsMap.put(Character.toLowerCase(c), button);
            buttonsMap.put(Character.toUpperCase(c), button);
        }
        keyboardPanel.add(row1, gbc);

        // Row 2: A - L
        gbc.gridy = 1;
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row2.setOpaque(false);
        row2.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        for (char c : "asdfghjkl".toCharArray()) {
            KeyBoardButtons button = new KeyBoardButtons(c);
            row2.add(button);
            buttonsMap.put(Character.toLowerCase(c), button);
            buttonsMap.put(Character.toUpperCase(c), button);
        }
        keyboardPanel.add(row2, gbc);

        // Row 3: Z - M
        gbc.gridy = 2;
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
        row3.setOpaque(false);
        row3.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        for (char c : "zxcvbnm".toCharArray()) {
            KeyBoardButtons button = new KeyBoardButtons(c);
            row3.add(button);
            buttonsMap.put(Character.toLowerCase(c), button);
            buttonsMap.put(Character.toUpperCase(c), button);
        }
        keyboardPanel.add(row3, gbc);

        // Pass the buttons map to the parent screen
        listener.setKeyboardButtonsMap(buttonsMap);
    }
    public static class KeyBoardButtons extends JButton {
        private final char value;
        private Color defaultBackground;

        public KeyBoardButtons(char value) {
            this.value = value;
            this.setFocusable(false);
            this.setText(String.valueOf(this.value).toUpperCase());
            this.setOpaque(true);
            this.setBorder(BorderFactory.createRaisedBevelBorder());
            this.setPreferredSize(new Dimension(40, 40));
            this.defaultBackground = this.getBackground();

            // Style the button
            this.setBackground(new Color(240, 240, 240)); // Light gray default
            this.setFont(new Font("Arial", Font.BOLD, 14));
        }

        public void highlight() {
            this.setBackground(Color.YELLOW);
        }

        public void unhighlight() {
            this.setBackground(defaultBackground);
        }

        public char getValue() {
            return this.value;
        }
    }
}