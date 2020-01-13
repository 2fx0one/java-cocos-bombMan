package com.tfx0one.bombGame;

import com.tfx0one.gameEngine.Director;
import com.tfx0one.gameEngine.GameObject;
import com.tfx0one.gameEngine.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:05
 * @projectName java-cocos-bombman
 */
public class WallLayer extends GameObject {
    private Random r;
    private BufferedImage image;

    private boolean wallFlags[][];

    //墙的个数
    private int wallCount;

    @Override
    public void draw(Graphics g) {
        int cellSize = 32;
        int width = Director.getInstance().getWidth();
        int height = Director.getInstance().getHeight();

        for (int y = 0; y < height / cellSize; y++) {
            for (int x = 0; x < width / cellSize; x++) {
                if (wallFlags[y][x]) {
                    g.drawImage(image,
                            x * cellSize,
                            y * cellSize, null);
                }
            }
        }

    }

    @Override
    public void init() {
        wallCount = 60;
        r = new Random();
        int cellSize = 32;
        int width = Director.getInstance().getWidth();
        int height = Director.getInstance().getHeight();

        wallFlags =
                new boolean[height / cellSize][width / cellSize];

        int i = 0;
        while (i < wallCount) {
            int rX = r.nextInt(width / cellSize);
            int rY = r.nextInt(height / cellSize);
            //设置
            if (canSetWall(rX, rY)) {
                wallFlags[rY][rX] = true;
                i++;
            }
        }
        this.image = Utils.getImage("image/wall.png");
    }

    private boolean canSetWall(int x, int y) {
        if (!(x % 2 == 0 && y % 2 == 0)
                && (!wallFlags[y][x])
                && (y > 2) //title 不能放墙
                && x != 0
        ) {

            return true;
        } else {
            return false;
        }
    }
}

