import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartScreen extends JPanel implements ActionListener{
    Buttons.PlayButton playButton;
    Buttons.PlayButton exitButton;
    CardLayout cardLayout;
    JPanel container;
  public StartScreen(ImageIcon backgroundImg, JPanel container, CardLayout cardLayout){

      JLabel startPanelBG= new JLabel(backgroundImg);
      startPanelBG.setLayout(new BorderLayout());
      int buttonWidth = 100;
      int buttonHeight = 50;
      this.cardLayout= cardLayout;
      this.container= container;

      exitButton = new Buttons.PlayButton("Exit", 0, 0, buttonWidth, buttonHeight, container, cardLayout);
      this.exitButton.addActionListener(this);
      Styles.getStyleButton(this.exitButton);

      this.playButton = new Buttons.PlayButton("PLAY",0, 0, buttonWidth, buttonHeight, container, cardLayout);
      this.playButton.addActionListener(this);
      Styles.getStyleButton(this.playButton);

      JPanel buttonPanel = new JPanel(new BorderLayout());
      buttonPanel.setOpaque(false);
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

      JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
      leftPanel.setOpaque(false);
      leftPanel.add(exitButton);

      JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
      rightPanel.setOpaque(false);
      rightPanel.add(playButton);

      buttonPanel.add(leftPanel, BorderLayout.WEST);
      buttonPanel.add(rightPanel, BorderLayout.EAST);

      startPanelBG.add(buttonPanel, BorderLayout.SOUTH);
      this.setLayout(new BorderLayout());
      this.add(startPanelBG, BorderLayout.CENTER);

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
