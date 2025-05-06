import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartPanel extends JPanel implements ActionListener{
    PlayButton playButton;
    PlayButton exitButton;
    CardLayout cardLayout= new CardLayout();
    JPanel container= new JPanel();
    StartPanel(int WIDTH, int HEIGHT,ImageIcon backgroundImg, JPanel container,CardLayout cardLayout){

        JLabel startPanelBG= new JLabel(backgroundImg);

        // Sets up the button dimensions
        int buttonWidth = 100;
        int buttonHeight = 50;
        int playButtonY = HEIGHT - (buttonHeight * 3);
        this.cardLayout= cardLayout;
        this.container= container;

        // Sets up the PLAY button
        String playButtonText = "PLAY";
        int playButtonX = (WIDTH/2) -(buttonWidth + 20);
        this.playButton = new PlayButton(playButtonText, playButtonX, playButtonY, buttonWidth, buttonHeight, container, cardLayout);
        this.playButton.addActionListener(this);

        String playExitText = "Exit";
        int exitButtonX = (WIDTH / 2) + 20;;
        this.exitButton = new PlayButton(playExitText, exitButtonX, playButtonY, buttonWidth, buttonHeight, container, cardLayout);
        this.exitButton.addActionListener(this);

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
        if (e.getSource() == playButton) {
            // Handle PLAY button click

            if (this.cardLayout != null && container != null) {
                cardLayout.show(container, "2"); // Switch to players input screen
            }
        }
        else if (e.getSource() == exitButton) {
            // Handle Exit button click
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose(); // Close the application
            }
        }
    }

}
