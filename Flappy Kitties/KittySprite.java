import java.util.AbstractMap;
import java.awt.*; 
import javax.swing.ImageIcon; 

public class KittySprite {

    @SuppressWarnings("unchecked")
    AbstractMap.SimpleEntry<Image, ImageIcon>[] kitties = new AbstractMap.SimpleEntry[]{
            new AbstractMap.SimpleEntry<>(
                new ImageIcon("img/cat1.png").getImage(),
                new ImageIcon("img/cat1B.png")
            ),
            new AbstractMap.SimpleEntry<>(
                new ImageIcon("img/cat2.png").getImage(),
                new ImageIcon("img/cat2B.png")
            ),
            new AbstractMap.SimpleEntry<>(
                new ImageIcon("img/cat3.png").getImage(),
                new ImageIcon("img/cat3B.png")
            ),
            new AbstractMap.SimpleEntry<>(
                new ImageIcon("img/cat5.png").getImage(),
                new ImageIcon("img/cat5B.png")
            ),
            new AbstractMap.SimpleEntry<>(
                new ImageIcon("img/cat4.png").getImage(),
                new ImageIcon("img/cat4B.png")
            )
    };

    public AbstractMap.SimpleEntry<Image, ImageIcon>[] getKitties() {
        return kitties;
    }

    public Image getPickedKittyA(int index){
        return kitties[index].getKey();
    }

    public ImageIcon getPickedKittyB(int index){
        return kitties[index].getValue();
    }

    public AbstractMap.SimpleEntry<Image, ImageIcon> getPickedKitty(int index) {
        return kitties[index];
    }
            

    
}
