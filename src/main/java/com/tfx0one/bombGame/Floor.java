package com.tfx0one.bombGame;

import com.tfx0one.gameEngine.Director;
import com.tfx0one.gameEngine.GameObject;

import java.awt.*;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:04
 * @projectName java-cocos-bombman
 */
public class Floor extends GameObject {
    @Override
    public void draw(Graphics g) {
        int width = Director.getInstance().getWidth();
        int height = Director.getInstance().getHeight();
        Color old = g.getColor();
        g.setColor(new Color(0, 184, 0));
        g.fillRect(x, y, width, height);
        g.setColor(old);
    }
}