package com.tfx0one.gameEngine;


import javax.swing.*;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:02
 * @projectName java-cocos-bombman
 */
public class Director {
    private static Director instance;

    private Director() { //构造器私有
    }

    //单例模式-简单版本
    public static Director getInstance() {
        if (instance == null) {
            instance = new Director();
            instance.init();
        }
        return instance;
    }

    private void init() {

    }

    private int width;
    private int height;

    public void setScreen(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public void runWithScene(BaseScene baseScene) {
        JFrame win = new JFrame("cocos-2d-Engine");
        win.setSize(this.width+20, this.height+42);

        //设置关闭行为（点击红X）
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setLocationRelativeTo(null);//居中

        win.add(baseScene);
        win.setVisible(true);

        for (;;) {
            baseScene.runLoop(); //游戏的主循环
            baseScene.repaint(); //重新绘制场景
            try {
                Thread.sleep(timeInterval);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long timeInterval; //1000/60
    public void setTimeInterval(long i) {
        timeInterval = i;
    }

}
