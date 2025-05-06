import javax.swing.*;
import java.awt.*;

public class Styles {
    public static JTextField getJTextFieldStyle() {
        JTextField field = new JTextField(5);
        field.setForeground(Color.BLACK);
        field.setOpaque(true);
        field.setFont(new Font("SansSerif", Font.PLAIN, 20));
        field.setBackground(new Color(255, 255, 255, 200));
        return field;
    }

    public static void getStyleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(120, 40));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }

}
