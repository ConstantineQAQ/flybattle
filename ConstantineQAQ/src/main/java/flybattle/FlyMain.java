package flybattle;

import flybattle.component.FlyPanel;

import javax.swing.*;

public class FlyMain {
    //设置窗口的大小
    static final int width = 600;
    static final int height = 800;

    public static void main(String[] args) {
        //新建JFrame并命名
        JFrame jFrame = new JFrame();

        //设置容器大小
        jFrame.setSize(width,height);

        //设置标题
        jFrame.setTitle("能天使大战杰斯顿");

        //设置退出
        jFrame.setDefaultCloseOperation(3);

        //设置窗口居中
        jFrame.setLocationRelativeTo(null);

        //创建JPanel容器
        FlyPanel flyPanel = new FlyPanel();

        //将容器加入到JFrame中
        jFrame.add(flyPanel);


        //添加鼠标监听器
        jFrame.addMouseMotionListener(flyPanel);


        //设置可见
        jFrame.setVisible(true);

        //初始化
        flyPanel.init();


    }
}
