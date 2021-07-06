import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelDuszki extends JPanel implements Runnable, KeyListener {
    Thread thread = new Thread(this);
    Thread thread1 = new Thread(this::duszek1);
    Thread thread2 = new Thread(this::duszek2);
    Thread thread3 = new Thread(this::duszek3);
    Thread thread4 = new Thread(this::duszek4);
    Thread thread5 = new Thread(this::duszek5);

    int y = -80, p = -30, i = -130, o = 0, u = 50, t = 200, r = 10, z = 240, w = 350;

    PanelDuszki() {
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        setBackground(Color.BLACK);
    }

    public void run() {
        while (true) {
            pacMan(10, 350);
            duszek1();
            duszek2();
            duszek3();
            duszek4();
            duszek5();
            repaint();
        }
    }

    public void sleep(int time) {
        try {

            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void duszek1() {
        while (true) {
            y++;
            repaint();
            sleep(7);
            if (y > 350)
                y = -80;
        }
    }

    public void duszek2() {
        while (true) {
            p++;
            repaint();
            sleep(10);
            if (p > 350)
                p = -30;
        }
    }

    public void duszek3() {
        while (true) {
            i++;
            repaint();
            sleep(5);
            if (i > 350)
                i = -30;
        }
    }

    public void duszek4() {
        while (true) {
            r++;
            repaint();
            sleep(6);
            if (r > 350)
                r = -30;
        }
    }

    public void duszek5() {
        while (true) {
            u++;
            repaint();
            sleep(10);
            if (u > 350)
                u = -30;
        }
    }

    public void pacMan(int lewo, int prawo) {
        o = lewo;
        w = prawo;
        while (o < prawo || w > lewo) {
            if (t == 30 && y == z) {
                y = -80;
            } else if (t == 110 && p == z) {
                p = -30;
            } else if (t == 270 && r == z) {
                r = -10;
            } else if (t == 190 && i == z) {
                i = -130;
            } else if (t == 350 && u == z) {
                u = -10;
            }
            repaint();
        }
    }

    public void lewo(int i) {
        if (o < 0) {
        } else {
            o = t - i;
            t = o;
            repaint();
        }
    }

    public void prawo(int i) {
        if (o > 350) {
        } else {
            o = t + i;
            t = o;
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(getBackground());
        g2D.fillRect(0, 0, getSize().width, getSize().height);

        Image ghost = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        g.drawImage(ghost, 30, y, null);
        Image ghost1 = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        g.drawImage(ghost1, 110, p, null);
        Image ghost2 = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        g.drawImage(ghost2, 190, i, null);
        Image ghost3 = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        g.drawImage(ghost3, 270, r, null);
        Image ghost4 = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        g.drawImage(ghost4, 350, u, null);

        Image pacMan = new ImageIcon(getClass().getClassLoader().getResource("pacman up.gif")).getImage();
        g.drawImage(pacMan, t, z, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int b = e.getKeyCode();
        if (b == KeyEvent.VK_LEFT || b == KeyEvent.VK_A) {
            lewo(5);
        }
        if (b == KeyEvent.VK_RIGHT || b == KeyEvent.VK_D) {
            prawo(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
