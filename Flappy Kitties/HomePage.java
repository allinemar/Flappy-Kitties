import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JPanel {

    Palette color = new Palette();
    JLabel title = new JLabel(new ImageIcon("img/title.png"));
    ImageIcon playButton1 = new ImageIcon("img/playButton1.png");
    ImageIcon playButton2 = new ImageIcon("img/playButton2.png");
    JButton playButton = new JButton(playButton1);

    public HomePage(Runnable goToChoose) {

        setPreferredSize(new Dimension(600, 600));
        setBackground(color.pink());
        setLayout(new BorderLayout());

        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.CENTER);

        playButton.setHorizontalAlignment(SwingConstants.RIGHT);
        playButton.setMargin(new Insets(0, 0, 20, 20));
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.setOpaque(false);
        add(playButton, BorderLayout.SOUTH);

        playButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                playButton.setIcon(playButton2);
            }

            public void mouseExited(MouseEvent e) {
                playButton.setIcon(playButton1);
            }
        });

        playButton.addActionListener(e -> goToChoose.run());
    }
}
