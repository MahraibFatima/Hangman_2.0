import javax.swing.*;
import java.awt.*;

public class TextStyle {
    public static JTextField getJTextField() {
        JTextField field = new JTextField(5);
        field.setForeground(Color.BLACK);
        field.setOpaque(true);
        field.setFont(new Font("SansSerif", Font.PLAIN, 20));
        field.setBackground(new Color(255, 255, 255, 200));
        return field;
    }
}
