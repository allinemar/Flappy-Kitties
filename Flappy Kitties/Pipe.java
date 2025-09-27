import java.awt.*;

public class Pipe {
    
    int x = 600;
    int y = 0;
    int width = 100;
    int height = 400;
    Image img;
    boolean passed = false;

    public Pipe(Image img){
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImg() {
        return img;
    }

    public boolean getPassed(){
        return passed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

}
