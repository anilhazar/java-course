package uzayoyunuyeeey;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ates {

    private int x;
    private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

public class Oyun extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(1, this);

    private int gecenSure = 0;
    private int harcananAtes = 0;

    private BufferedImage image;

    private ArrayList<Ates> atesler = new ArrayList<>();

    private int atesdirY = 1;

    private int topX = 0;

    public boolean kontrolEt() {
        for (Ates ates : atesler) {

            if (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(topX, 0, 20, 20))) {
                return true;
            }

        }
        return false;
    }

    public Oyun() {
        try {
            image = ImageIO.read(this.getClass().getResource("uzaygemisi.png"));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.BLACK);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gecenSure += 5;
        g.setColor(Color.blue);
        g.fillOval(topX, 0, 20, 20);
        g.drawImage(image, uzayGemisiX, 490, image.getWidth() / 10, image.getHeight() / 10, this);

        for (Ates ates : atesler) {
            if (ates.getY() < 0) {
                atesler.remove(ates);
            }
        }
        g.setColor(Color.red);

        for (Ates ates : atesler) {
            g.fill3DRect(ates.getX(), ates.getY(), 10, 20, true);
        }

        if (kontrolEt()) {
            timer.stop();
            String mesaj = "Tebriklerssss \n"
                    + "Harcanan Ates Sayisi: " + harcananAtes + 
                     "\nGecen Sure: " + gecenSure / 1000.0 + "sn";
            JOptionPane.showMessageDialog(this, mesaj);

            System.exit(0);
        }

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    private int topdirX = 2;

    private int uzayGemisiX = 0;

    private int dirUzayX = 20;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT) {
            if (uzayGemisiX <= 0) {
                uzayGemisiX = 0;
            } else {
                uzayGemisiX -= dirUzayX;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (uzayGemisiX >= 740) {
                uzayGemisiX = 740;
            } else {
                uzayGemisiX += dirUzayX;
            }
        } else if (c == KeyEvent.VK_CONTROL) {
            atesler.add(new Ates(uzayGemisiX + 15, 470));

            harcananAtes++;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Ates ates : atesler) {
            ates.setY(ates.getY() - atesdirY);
        }

        topX += topdirX;
        if (topX >= 750) {
            topdirX = -topdirX;
        }
        if (topX <= 0) {
            topdirX = -topdirX;

        }
        repaint();
    }

}
