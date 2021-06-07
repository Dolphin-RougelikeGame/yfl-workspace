package com.example.dolphin.bussiness;

import com.example.dolphin.bussiness.parts.EnemyTank;
import com.example.dolphin.bussiness.parts.Missile;
import com.example.dolphin.bussiness.parts.OursTank;

/**
 * Created by THINK on 2018/8/10.
 */

public interface ITankHitHandler {
    /**
     * 敌方坦克被击毁
     * @param destroy
     */
    void onEnemyTankDestroy(EnemyTank destroy);

    /**
     * 我方坦克被击毁
     * @param oursTank
     */
    void onOursTankDestroy(OursTank oursTank);

    /**
     * 敌方开火
     */
    void onEnemyFire(Missile missile);

    /**
     * 我方开火
     * @param missile
     */
    void onOursFire(Missile missile);
}
