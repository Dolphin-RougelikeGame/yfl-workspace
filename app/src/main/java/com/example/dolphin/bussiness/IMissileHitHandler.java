package com.example.dolphin.bussiness;

import com.example.dolphin.bussiness.parts.Missile;

/**
 * Created by THINK on 2018/8/10.
 */

public interface IMissileHitHandler {
    void onHit(Missile missile);
}
