
import javax.swing.*;

public class KeyBoardButtons extends JButton {
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