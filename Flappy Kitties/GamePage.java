import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class GamePage extends JPanel implements ActionListener, KeyListener {
    Runnable goToGameOver;

    Palette color = new Palette();
    Image kittyImg;
    Image backgroundImg;
    Image topPipeImg;
    Image bottomPipeImg;

    Kitty kitty;
    int kittyX = 600 / 8;
    int kittyY = 300;

    ArrayList<Pipe> pipes;
    int pipeX = 600;
    int pipeY = 0;

    int velocityX = -4;
    int velocityY = 0;
    int gravity = 1;
    Random random = new Random();
    Timer gameLoop;
    Timer placePipesTimer;

    boolean gameOver = false;
    double score = 0;

    public GamePage(Image kittyImg, Runnable goToGameOver) {
        this.goToGameOver = goToGameOver;
        
        setSize(600, 600);
        setFocusable(true);
        addKeyListener(this);

        this.kittyImg = kittyImg;
        backgroundImg = new ImageIcon(getClass().getResource("img/backgroundImg.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("img/topPipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("img/bottomPipe.png")).getImage();

        kitty = new Kitty(kittyImg);
        pipes = new ArrayList<Pipe>();

        placePipesTimer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        placePipesTimer.start();
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

    }

    public void placePipes() {
        Pipe topPipe = new Pipe(topPipeImg);

        int randomPipeY = (int) (pipeY - topPipe.getHeight() / 4 - Math.random() * topPipe.getHeight() / 2);
        int gap = 180;

        topPipe.setY(randomPipeY);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.setY(topPipe.getY() + topPipe.getHeight() + gap);
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, 600, 600, null);
        g.drawImage(kittyImg, kitty.getX(), kitty.getY(), null);

        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImg(), pipe.getX(), pipe.getY(), null);

        }

        g.setColor(Color.white);
        g.setFont(new Font("DialogInput", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        velocityY += gravity;
        kitty.setY(Math.max(0, kitty.getY() + velocityY));
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setX(pipe.getX() + velocityX);

            if (!pipe.passed && kitty.getX() > pipe.getX() + pipe.getWidth()) {
                pipe.setPassed(true);
                score += 0.5;
            }

            if (collision(kitty, pipe))
                gameOver = true;
        }

        if (kitty.getY() > 600)
            gameOver = true;

    }

    public boolean collision(Kitty k, Pipe p) {
        return k.getX() < p.getX() + p.getWidth() && k.getX() + k.getWidth() > p.getX()
                && k.getY() < p.getY() + p.getHeight() && k.getY() + k.getHeight() > p.getY();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();

            new javax.swing.Timer(2000, evt -> {
                goToGameOver.run();
            }) {
                {
                    setRepeats(false); // run only once
                    start();
                }
            };

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
