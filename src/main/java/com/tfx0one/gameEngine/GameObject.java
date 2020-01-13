package com.tfx0one.gameEngine;

import java.awt.*;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:02
 * @projectName java-cocos-bombman
 */

public abstract class GameObject {
    //访问控制属性 protected 继承的类可以直接访问属性。
    protected int x;
    protected int y;
    public GameObject() {
        init();
    }
    //	public abstract void init();
    public void init() {}
    //	public abstract void update();
    public void update() {}
    public abstract void draw(Graphics g);
}
