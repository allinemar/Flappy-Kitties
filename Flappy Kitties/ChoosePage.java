import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.AbstractMap;
import java.util.function.Consumer;

public class ChoosePage extends JPanel {

    Palette color = new Palette();
    ImageIcon goButton1 = new ImageIcon("img/goButton1.png");
    ImageIcon goButton2 = new ImageIcon("img/goButton2.png");
    JButton goButton = new JButton(goButton1);
    KittySprite kitties = new KittySprite();
    /* 
     ImageIcon[] kitties = new ImageIcon[] {
            new ImageIcon("img/cat1B.png"),
            new ImageIcon("img/cat2B.png"),
            new ImageIcon("img/cat3B.png"),
            new ImageIcon("img/cat4B.png")
    };
    */
    JLabel pickText = new JLabel(new ImageIcon("img/pickText.png"));
    JLabel kittyDisplaying = new JLabel(kitties.getPickedKittyB(0));
    int index = 0;

    public ChoosePage(Consumer<AbstractMap.SimpleEntry<Image, ImageIcon>> goToGame) {

        setPreferredSize(new Dimension(600, 600));
        setBackground(color.pink());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ImageIcon prev1 = new ImageIcon("img/prevArrow1.png");
        ImageIcon prev2 = new ImageIcon("img/prevArrow2.png");
        ImageIcon next1 = new ImageIcon("img/nextArrow1.png");
        ImageIcon next2 = new ImageIcon("img/nextArrow2.png");

        JButton prev = new JButton(prev1);
        JButton next = new JButton(next1);

        prev.setIcon(prev1);
        prev.setRolloverIcon(prev2);

        next.setIcon(next1);
        next.setRolloverIcon(next2);

        prev.setPreferredSize(new Dimension(24, 35));
        next.setPreferredSize(new Dimension(24, 35));

        setButton(prev);
        setButton(next);
        setButton(goButton);

        prev.addActionListener(e -> showPreviousImage());
        next.addActionListener(e -> showNextImage());

        goButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                goButton.setIcon(goButton2);
            }

            public void mouseExited(MouseEvent e) {
                goButton.setIcon(goButton1);
            }
        });

        JPanel slidePanel = new JPanel();
        slidePanel.setLayout(new BoxLayout(slidePanel, BoxLayout.LINE_AXIS));
        slidePanel.setOpaque(false);
        prev.setAlignmentY(Component.CENTER_ALIGNMENT);
        kittyDisplaying.setAlignmentY(Component.CENTER_ALIGNMENT);
        next.setAlignmentY(Component.CENTER_ALIGNMENT);
        slidePanel.add(prev);
        slidePanel.add(Box.createHorizontalStrut(10));
        slidePanel.add(kittyDisplaying);
        slidePanel.add(Box.createHorizontalStrut(10));
        slidePanel.add(next);

        add(Box.createVerticalStrut(35));
        pickText.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(pickText);
        slidePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(slidePanel);
        goButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goButton.setMargin(new Insets(0, 0, 50, 0));
        //goButton.setPreferredSize(new Dimension(92, 90));
        add(goButton);

        goButton.addActionListener(e -> {
            goToGame.accept(kitties.getPickedKitty(index));
        });
    }

    private void showPreviousImage() {
        index = (index - 1 + kitties.getKitties().length) % kitties.getKitties().length;
        kittyDisplaying.setIcon(kitties.getPickedKittyB(index));
    }

    private void showNextImage() {
        index = (index + 1) % kitties.getKitties().length;
        kittyDisplaying.setIcon(kitties.getPickedKittyB(index));
    }

    private void setButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

}
