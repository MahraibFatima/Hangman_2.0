import javax.swing.*;
import java.awt.*;

public class Background {
    public static JPanel setBackgroundPanel(ImageIcon bgImg){
        JPanel background = new BackgroundPanel(bgImg.getImage());
        background.setLayout(new BorderLayout());
        return background;
    }

    public static class BackgroundPanel extends JPanel {
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