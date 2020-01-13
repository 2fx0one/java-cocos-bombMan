package com.tfx0one.gameEngine;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:41
 * @projectName java-cocos-bombman
 */
public class Utils {
    public static BufferedImage getImage(String name) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(
                    Utils.class.getResource("/"+name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
