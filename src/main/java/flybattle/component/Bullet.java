package flybattle.component;

import javax.swing.*;
import java.awt.*;

/*
 * 子弹对象
 * */

public class Bullet {

    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon bulletImageIcon = new ImageIcon("resources/bullet.png");

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = bulletImageIcon.getIconWidth();
        this.height = bulletImageIcon.getIconHeight();
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageIcon getBulletImageIcon() {
        return bulletImageIcon;
    }

    public void setBulletImageIcon(ImageIcon bulletImageIcon) {
        this.bulletImageIcon = bulletImageIcon;
    }

    public void move() {
        this.y -= 4;
    }

/*    public void move2() {
        this.y -= 4;
        this.x -= 4;
    }*/

    public void drawImage(Graphics g) {
        g.drawImage(bulletImageIcon.getImage(), x, y, null);

    }
}

