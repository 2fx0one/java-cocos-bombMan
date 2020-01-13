package com.tfx0one.gameEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:02
 * @projectName java-cocos-bombman
 */
public class Animation extends GameObject {
    private int x;
    private int y;
    private BufferedImage anims[];
    private int len; //图片的个数
    private BufferedImage curImage;//当前绘制的
    private int index;
    private int speed = 8;//越大越慢

    public Animation(URL... urls) {
        try {
            len = urls.length;
            int i = 0;
            anims = new BufferedImage[urls.length];
            for (URL u : urls) {
                anims[i++] = ImageIO.read(u);
            }
            curImage = anims[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(
                curImage,
                x, y, null);
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        //int s = 60 / speed; //越大越快
        curImage = anims[++index / speed % len];
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}