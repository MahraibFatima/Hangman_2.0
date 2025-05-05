import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HangmanGame extends JPanel implements ActionListener {

    ImageIcon background;

    public HangmanGame(ImageIcon backgroundImg) {
        this.background = backgroundImg;
        this.setLayout(new BorderLayout());

        // Background panel with keyboard at SOUTH
        JPanel backgroundWithKeyboard = Background.setBgWithKeyBoard(backgroundImg);

        JPanel centerPanel = createCenterPanel();//combine chance panel + image panel
        backgroundWithKeyboard.add(centerPanel, BorderLayout.CENTER);

//        JPanel guessWord_panel= guessWord_panel();
//        backgroundWithKeyboard.add(guessWord_panel, BorderLayout.CENTER);

//        Buttons exit= new Buttons("Exit",2,3, 3, 5);
//        backgroundWithKeyboard.add(exit, BorderLayout.SOUTH);
        // Add to main panel

        this.add(backgroundWithKeyboard, BorderLayout.CENTER);

    }

    private static JPanel chances_panel(){
        JPanel guessWord_panel = new JPanel(new GridLayout(8, 1, 10, 10));
        guessWord_panel.setOpaque(false);
        guessWord_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel chancesLeft_label= new JLabel("Chance Left", SwingConstants.LEFT);
        chancesLeft_label.setFont(font);

        JButton chanceLeft_button= new JButton();
        chanceLeft_button.setText("5");
        chanceLeft_button.setEnabled(false);

        guessWord_panel.add(chancesLeft_label);
        guessWord_panel.add(chanceLeft_button);

        return guessWord_panel;
    }
    private static JPanel imageToEast() {
        ImageIcon img = new ImageIcon("img/Gallows6.gif");

        JLabel imageLabel = new JLabel(img);
        JPanel imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        imagePanel.add(imageLabel);

        return imagePanel;
    }
    private static JPanel guessWord_panel() {
        JPanel guessWord_panel = new JPanel(new GridLayout(2, 1, 10, 10));
        guessWord_panel.setOpaque(false);
        guessWord_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel guessWord_label= new JLabel("Guess Word ", SwingConstants.LEFT);
        guessWord_label.setFont(font);


        JTextField guessWord_field = TextFieldStyle.getJTextField();

        guessWord_panel.add(guessWord_label);
        guessWord_panel.add(guessWord_field);

        return guessWord_panel;
    }
    private JPanel createCenterPanel() {
        // --- LEFT SIDE: Chances Left ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.add(chances_panel(), BorderLayout.CENTER);

        // --- RIGHT SIDE: Image Panel ---
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(imageToEast(), BorderLayout.CENTER);

        // --- CENTER SIDE: guessWord Panel ---
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(guessWord_panel(), BorderLayout.CENTER);

        // --- CENTER PANEL: Contains left and right ---
        JPanel mainCenterPanel = new JPanel(new BorderLayout());
        mainCenterPanel.setOpaque(false);
        mainCenterPanel.add(leftPanel, BorderLayout.WEST);
        mainCenterPanel.add(rightPanel, BorderLayout.EAST);
        mainCenterPanel.add(centerPanel, BorderLayout.SOUTH);

        return mainCenterPanel;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background chalk board is showing.
//        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement logic later
    }
}