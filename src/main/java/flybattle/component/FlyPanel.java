package flybattle.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class FlyPanel extends JPanel implements MouseMotionListener {


    //读取英雄机的图片
    ImageIcon heroImage = new ImageIcon("resources/nts.png");

    //定义一个集合来装所有的敌机
    ArrayList<Enemy> enemys = new ArrayList();

    //定义一个队列来装所有的子弹
    ArrayList<Bullet> bullets = new ArrayList();
    ArrayList<Bullet2> bullets2 = new ArrayList();
    ArrayList<Bullet3> bullets3 = new ArrayList();

    //定义一个集合来装爆炸的图片
    ArrayList<Boom> booms = new ArrayList();

    //飞机的初始坐标
    int planeX = 300;
    int planeY = 400;
    private int number = 0;
    private boolean isOver = false;
    private int hp = 3;
    private int level = 1;


    public FlyPanel() {
        //创建10个敌人
        if(level == 1) {
            for (int i = 0; i < 10; i++) {
                enemys.add(new Enemy());
            }
        }else if(level == 2){
            for (int i = 0; i < 30; i++) {
                enemys.add(new Enemy());
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();//获取鼠标的x值
        int y = e.getY();//获取鼠标的y值

        planeX = x - (heroImage.getIconWidth() / 2); //把鼠标的x赋值给英雄机
        planeY = y - (heroImage.getIconHeight() / 2);//把鼠标的y赋值给英雄机


    }

    //鼠标移动时调用
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();//获取鼠标的x值
        int y = e.getY();//获取鼠标的y值

        planeX = x - (heroImage.getIconWidth() / 2); //把鼠标的x赋值给英雄机
        planeY = y - (heroImage.getIconHeight() / 2);//把鼠标的y赋值给英雄机

        repaint();//x发生变化后需要重新绘制

    }

    //敌方碰撞方法
    public boolean isHit(Enemy e, Bullet b) {
        //指定一个区域
        Rectangle rect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());

        //表示（x，y）坐标空间中的位置的点
        Point p = new Point(b.getX() + b.getWidth() / 2, b.getY() + b.getHeight());

        return rect.contains(p);
    }

    public boolean isHit2(Enemy e, Bullet2 b) {
        //指定一个区域
        Rectangle rect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());

        //表示（x，y）坐标空间中的位置的点
        Point p = new Point(b.getX() + b.getWidth() / 2, b.getY() + b.getHeight());

        return rect.contains(p);
    }

    public boolean isHit3(Enemy e, Bullet3 b) {
        //指定一个区域
        Rectangle rect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());

        //表示（x，y）坐标空间中的位置的点
        Point p = new Point(b.getX() + b.getWidth() / 2, b.getY() + b.getHeight());

        return rect.contains(p);
    }


    //重写paint方法，做绘制图片使用
    public void paint(Graphics g) {
        super.paint(g);
        //判断游戏是否结束
        if (isOver) {
            g.setColor(Color.BLUE);

            g.setFont(new Font("Times", Font.BOLD, 30));

            g.drawString("游戏结束!", 250, 400);
        } else {

            g.setFont(new Font("", Color.RED.getRed(), 30));
            g.drawString("得分" + number, 20, 30);
            g.drawString("生命值" + hp, 20, 60);
            g.drawString("等级" + level, 20, 90);

            //1.绘制主机
            g.drawImage(heroImage.getImage(), planeX, planeY, null);


            //2.绘制敌机
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);
                enemy.drawImage(g);//重新绘制
            }

            //3.绘制子弹
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.drawImage(g);
            }

            for (int i = 0; i < bullets2.size(); i++) {
                Bullet2 bullet2 = bullets2.get(i);
                bullet2.drawImage(g);
            }

            for (int i = 0; i < bullets3.size(); i++) {
                Bullet3 bullet3 = bullets3.get(i);
                bullet3.drawImage(g);
            }

            //4.绘制爆炸图片
            for (int i = 0; i < booms.size(); i++) {
                Boom boom = booms.get(i);
                boom.drawImage(g);
            }

        }
    }

    /*
     * init这个方法做初始化方法使用
     * 创建一些组件（主机，子弹，敌人）
     * */

    public void init() {
        int flag = 0;

        while (true) {

            flag++;
            if (level == 1) {
                //每循环20次创建一个子弹
                if (flag % 15 == 0) {

                    //创建一些子弹
                    Bullet bullet = new Bullet(planeX + heroImage.getIconWidth() / 2, planeY);

                    //把子弹添加到集合中
                    bullets.add(bullet);
                }
            }

            if (level == 2) {
                for (int i = 0; i < bullets.size(); i++) {
                    Bullet bullet = bullets.get(i);
                    bullets.remove(bullet);
                }
                //每循环20次创建一个子弹
                if (flag % 15 == 0) {

                    //创建一些子弹
//                    Bullet bullet = new Bullet(planeX + heroImage.getIconWidth() / 2, planeY);
                    Bullet2 bullet2 = new Bullet2(planeX + heroImage.getIconWidth() / 2, planeY);
                    Bullet3 bullet3 = new Bullet3(planeX + heroImage.getIconWidth() / 2, planeY);

                    //把子弹添加到集合中
//                    bullets.add(bullet);
                    bullets2.add(bullet2);
                    bullets3.add(bullet3);
                }
            }

            //让敌机往下移动
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);
                if (level == 1) {
                    enemy.move();//改变敌机的y值
                }else if(level == 2){
                    enemy.move2();
                }

                //判断敌机的y值是否大于整个窗口的高度
                if (enemy.getY() > 800) {
                    //删除敌机
                    enemys.remove(enemy);
                    hp--;

                    //再添加一个新的敌机
                    enemys.add(new Enemy());
                }

            }

            //让子弹飞起来
            if (level == 1) {
                for (int i = 0; i < bullets.size(); i++) {
                    Bullet tempBullet = bullets.get(i);
                    tempBullet.move();
                }
            }

            if (level == 2) {
                for (int i = 0; i < bullets2.size(); i++) {
                    Bullet2 tempBulletLevel2 = bullets2.get(i);
                    tempBulletLevel2.move2();
                }
                /*for (int i = 0; i < bullets.size(); i++) {
                    Bullet tempBulletLevel = bullets.get(i);
                    tempBulletLevel.move();
                }*/
                for (int i = 0; i < bullets3.size(); i++) {
                    Bullet3 tempBulletLevel3 = bullets3.get(i);
                    tempBulletLevel3.move3();
                }
            }

            //删除越界的子弹
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if (bullet.getY() < 0) {
                    //y轴小于零说明越界了
                    bullets.remove(bullet);
                }
            }
            for (int i = 0; i < bullets2.size(); i++) {
                Bullet2 bullet2 = bullets2.get(i);
                if (bullet2.getY() < 0) {
                    //y轴小于零说明越界了
                    bullets.remove(bullet2);
                }
            }
            for (int i = 0; i < bullets3.size(); i++) {
                Bullet3 bullet3 = bullets3.get(i);
                if (bullet3.getY() < 0) {
                    //y轴小于零说明越界了
                    bullets.remove(bullet3);
                }
            }


            //处理子弹碰撞到敌机的效果
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);//敌机

                for (int j = 0; j < bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);//得到子弹

                    if (isHit(enemy, bullet)) {
                        //先删除敌机
                        enemys.remove(enemy);//先删除击中的敌机
                        enemys.add(new Enemy());//再添加一个新的敌机
                        bullets.remove(bullet);//删除子弹

                        //创建一个爆炸图片的对象
                        Boom boom = new Boom(enemy.getX(), enemy.getY());
                        booms.add(boom);//添加到集合中
                        number += 10;//每次碰撞加10分
                    }
                }

                for (int k = 0; k < bullets2.size(); k++) {
                    Bullet2 bullet2 = bullets2.get(k);//得到子弹

                    if (isHit2(enemy, bullet2)) {
                        //先删除敌机
                        enemys.remove(enemy);//先删除击中的敌机
                        enemys.add(new Enemy());//再添加一个新的敌机
                        bullets.remove(bullet2);//删除子弹

                        //创建一个爆炸图片的对象
                        Boom boom = new Boom(enemy.getX(), enemy.getY());
                        booms.add(boom);//添加到集合中
                        number += 10;//每次碰撞加10分
                    }
                }

                for (int l = 0; l < bullets3.size(); l++) {
                    Bullet3 bullet3 = bullets3.get(l);//得到子弹

                    if (isHit3(enemy, bullet3)) {
                        //先删除敌机
                        enemys.remove(enemy);//先删除击中的敌机
                        enemys.add(new Enemy());//再添加一个新的敌机
                        bullets.remove(bullet3);//删除子弹

                        //创建一个爆炸图片的对象
                        Boom boom = new Boom(enemy.getX(), enemy.getY());
                        booms.add(boom);//添加到集合中
                        number += 10;//每次碰撞加10分
                    }
                }
            }

            //删除爆炸的图片
            for (int i = 0; i < booms.size(); i++) {
                Boom boom = booms.get(i);
                boom.move();
                if (boom.getCount() > 5) {
                    booms.remove(boom);
                }
            }

            //到1000分时进入第二关
            if (number == 100) {
                level = 2;
            }


            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (hp == 0) {
                isOver = true;
            }

            repaint();
        }
    }
}
