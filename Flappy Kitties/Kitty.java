import java.awt.*;

public class Kitty {
    int x=50;
    int y=300;
    int width = 63;
    int height = 64;
    
    Image img;

    public Kitty(Image img){
        this.img = img;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int w){
        x=w;
    }

    public void setY(int h){
        y=h;
    }
}
