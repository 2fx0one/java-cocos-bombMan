package com.tfx0one.bombGame;

import com.tfx0one.gameEngine.Director;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:01
 */
public class MainGame {

    public static void main(String[] args) {

        //1 创建导演
        Director d = Director.getInstance();
        d.setScreen(1024, 768);
        d.setTimeInterval(1000/30);//帧数

        //2 创建场景
        StageScene scene = new StageScene();

        //3 运行场景
        d.runWithScene(scene);

    }

}