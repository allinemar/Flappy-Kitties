import javax.swing.*;
import java.awt.*;
import java.util.AbstractMap;
import java.util.function.Consumer;

public class Main {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Main() {
        frame = new JFrame("Flappy Kitties");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        HomePage hp = new HomePage(() -> showPage("ChoosePage"));

        
        ChoosePage cp = new ChoosePage((AbstractMap.SimpleEntry<Image, ImageIcon> chosenImage) -> {
            
            GamePage gp = new GamePage(chosenImage.getKey(), () -> {
                
                GameOverPage gop = new GameOverPage(chosenImage.getValue(), () -> {
                    showPage("ChoosePage"); 
                });
                cardPanel.add(gop, "GameOverPage");
                showPage("GameOverPage");
            });

            cardPanel.add(gp, "GamePage");
            showPage("GamePage");
            gp.requestFocus(true);
        });

        
        cardPanel.add(hp, "HomePage");
        cardPanel.add(cp, "ChoosePage");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private void showPage(String name) {
        cardLayout.show(cardPanel, name);
    }

    public static void main(String[] args) {
        new Main();
    }
}
