package com.tfx0one.bombGame;

import com.tfx0one.gameEngine.GameObject;
import com.tfx0one.gameEngine.BaseScene;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2020-01-13 10:04
 * @projectName java-cocos-bombman
 */
public class StageScene extends BaseScene {

    @Override
    public void init() {
        //1 创建游戏对象
        //2 添加到场景  this.add

        //创建地板
        //new Color(0, 184, 0)
        GameObject floor = new Floor();
        this.add(floor);

        GameObject stone = new StoneLayer();
        this.add(stone);

        GameObject walls = new WallLayer();
        this.add(walls);
    }

}