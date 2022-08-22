package flybattle.component;

import javax.swing.*;
import java.awt.*;

public class Boom {

    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon boomimg = new ImageIcon("resources/bomb.png");
    private int count;//删除的次数

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = boomimg.getIconWidth();
        this.height = boomimg.getIconHeight();
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


    public ImageIcon getBombimg() {
        return boomimg;
    }


    public void setBombimg(ImageIcon bombimg) {
        this.boomimg = bombimg;
    }


    public void drawImage(Graphics g) {
        g.drawImage(boomimg.getImage(), x, y, null);
    }


    public void move() {
        count++;
    }
}

