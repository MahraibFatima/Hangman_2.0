import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartPanel extends JPanel implements ActionListener{
    PlayButton playButton;
    PlayButton exitButton;

    StartPanel(int WIDTH, int HEIGHT,ImageIcon backgroundImg, JPanel container,CardLayout cardLayout){

        JLabel startPanelBG= new JLabel(backgroundImg);

        // Sets up the button dimensions
        int buttonWidth = 100;
        int buttonHeight = 50;
        int playButtonY = HEIGHT - (buttonHeight * 3);


        // Sets up the PLAY button
        String playButtonText = "PLAY";
        int playButtonX = (WIDTH/2) -(buttonWidth + 20);
        this.playButton = new PlayButton(playButtonText, playButtonX, playButtonY, buttonWidth, buttonHeight, container, cardLayout);
        String playExitText = "Exit";
        int exitButtonX = (WIDTH / 2) + 20;;
        this.exitButton = new PlayButton(playExitText, exitButtonX, playButtonY, buttonWidth, buttonHeight, container, cardLayout);

        this.setLayout(new BorderLayout());
        this.add(startPanelBG);
        startPanelBG.setLayout(null);
        startPanelBG.add(this.playButton);
        startPanelBG.add(this.exitButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
