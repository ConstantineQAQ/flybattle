package flybattle.component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy {
    private int width;//杰斯顿图片的宽度
    private int height;//杰斯顿图片的高度

    //杰斯顿的坐标
    private int x;
    private int y;

    //杰斯顿的图片
    private ImageIcon enemyImageIcon = new ImageIcon("resources/jsd.png");

    public Enemy() {
        this.width = enemyImageIcon.getIconWidth();
        this.height = enemyImageIcon.getIconHeight();

        //设置杰斯顿的位置
        Random random = new Random();
        random.nextInt(10);

        this.x = random.nextInt(600 - (width / 2) - 35);
        this.y = -random.nextInt(800 - (height / 2));

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

    public void move() {
        this.y += 1; //速度

    }

    public void move2() {
        this.y += 2;
    }

    public void drawImage(Graphics g) {
        g.drawImage(enemyImageIcon.getImage(), x, y, null);
    }
}

