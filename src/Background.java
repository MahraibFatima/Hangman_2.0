import javax.swing.*;
import java.awt.*;

public class Background {
    public static JPanel setBgWithKeyBoard(ImageIcon backgroundImg) {
        JPanel backgroundWithKeyboard = new BackgroundPanel(backgroundImg.getImage());
        backgroundWithKeyboard.setLayout(new BorderLayout());

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setOpaque(false);

        KeyBoard keyBoard = new KeyBoard();
        keyBoard.displayButtons(keyboardPanel);

        backgroundWithKeyboard.add(keyboardPanel, BorderLayout.SOUTH);
        return backgroundWithKeyboard;
    }

    static class BackgroundPanel extends JPanel {
        private final Image background;

        public BackgroundPanel(Image background) {
            this.background = background;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
