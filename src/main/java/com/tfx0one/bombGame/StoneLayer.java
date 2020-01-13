package com.tfx0one.bombGame;

import com.tfx0one.gameEngine.Director;
import com.tfx0one.gameEngine.GameObject;
import com.tfx0one.gameEngine.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:04
 * @projectName java-cocos-bombman
 */
public class StoneLayer extends GameObject {
    private BufferedImage bg;
    @Override
    public void draw(Graphics g) {
        g.drawImage(bg, x, y, null);
    }
    private BufferedImage image;

    @Override
    public void init() {
        initBGImage();
    }

    public void initBGImage(){
        this.image = Utils.getImage("image/stone.png");

        int titleheight = 64;
        int cellSize = 32;
        int width = Director.getInstance().getWidth();
        int height = Director.getInstance().getHeight();
        //new Color(191, 191, 191);
        int w = width / cellSize; //有多少格
        int h = height / cellSize; //有多少格

        //1 创建一个空白图片
        bg = new BufferedImage(
                width, height, BufferedImage.TYPE_4BYTE_ABGR);

        //2. 拿到画笔
        Graphics g = bg.getGraphics();

        //3 开始画画
        g.setColor(new Color(191, 191, 191));

        for (int x=0; x<=w; x++) {
            for (int y=0; y<=h; y++) {
                if (y == 2 || y==h ||
                        x == 0 || x==w ||
                        (x % 2 == 0 && y % 2 == 0)) {
                    g.drawImage(image,
                            x*cellSize,
                            y*cellSize,
                            null);
                }
            }
        }
        g.fillRect(0, 0, width, cellSize*2);

        for (int x=0; x < width; x += cellSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int y=0; y < height; y += cellSize) {
            g.drawLine(0, y, width, y);
        }


    }

}
