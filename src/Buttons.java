import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton {

    public Buttons(String text, int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFocusable(false);
    }

}

class PlayButton extends Buttons {

    public PlayButton(String text, int x, int y, int width, int height, JPanel container, CardLayout cardLayout) {
        super(text, x, y, width, height);
    }

}



