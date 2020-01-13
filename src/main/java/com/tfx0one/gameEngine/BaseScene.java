package com.tfx0one.gameEngine;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:02
 * @projectName java-cocos-bombman
 */
public abstract class BaseScene extends JPanel {
    private Vector<GameObject> gameObjects;

    public BaseScene() {
        gameObjects = new Vector<GameObject>();
        init();
    }

    public abstract void init(); //让子类实现

    //方法被final修饰之后， 不能在子类中覆盖
    public final void add(GameObject e) {
        gameObjects.add(e);
    }
    @Override
    public final void paint(Graphics g) {
        for (GameObject object : gameObjects) {
            object.draw(g);
        }
    }

    // class Scene的runLoop
    public final void runLoop() {
        for (GameObject o : gameObjects) {
            o.update();
        }
    }
}
