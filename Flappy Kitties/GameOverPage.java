import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverPage extends JPanel {

    Palette color = new Palette();

    ImageIcon yes1 = new ImageIcon("img/yesButton1.png");
    ImageIcon yes2 = new ImageIcon("img/yesButton2.png");
    ImageIcon no1 = new ImageIcon("img/noButton1.png");
    ImageIcon no2 = new ImageIcon("img/noButton2.png");

    JLabel gameOver = new JLabel(new ImageIcon("img/gameOver.png"));
    ImageIcon kittyImg;
    JLabel kitty;
    JLabel gameOverText = new JLabel(new ImageIcon("img/gameOverText.png"));
    JPanel buttonsPanel = new JPanel();
    JButton yesButton = new JButton();
    JButton noButton = new JButton();

    public GameOverPage(ImageIcon kittyImg, Runnable goToChoosePage) {

        // image
        this.kittyImg = kittyImg;
        kitty = new JLabel(kittyImg);

        // frame
        setSize(600, 600);
        setBackground(color.pink());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // buttons
        yesButton.setIcon(yes1);
        yesButton.setRolloverIcon(yes2);
        setButton(yesButton);
        yesButton.setAlignmentX(CENTER_ALIGNMENT);

        noButton.setIcon(no1);
        noButton.setRolloverIcon(no2);
        setButton(noButton);
        noButton.setAlignmentX(CENTER_ALIGNMENT);

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(noButton);
        buttonsPanel.add(yesButton);

        // alignments
        gameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOver.setAlignmentY(Component.CENTER_ALIGNMENT);
        kitty.setAlignmentX(Component.CENTER_ALIGNMENT);
        kitty.setAlignmentY(Component.CENTER_ALIGNMENT);
        gameOverText.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOverText.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonsPanel.setAlignmentY(Component.CENTER_ALIGNMENT);



        add(Box.createVerticalGlue());
        add(gameOver);
        add(Box.createVerticalStrut(25));
        add(kitty);
        add(Box.createVerticalStrut(25));
        add(gameOverText);
        add(Box.createVerticalStrut(35));
        add(buttonsPanel);
        add(Box.createVerticalGlue());

        yesButton.addActionListener(e -> goToChoosePage.run());
        noButton.addActionListener(e -> System.exit(0));

    }

    private void setButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

}
