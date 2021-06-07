package com.example.dolphin.bussiness.parts;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.dolphin.bussiness.Direction;

import java.util.List;

public class OursTank extends Tank {
    private Paint oursPaint;

    public void initOursTank() {
        oursPaint = new Paint();

        oursPaint.setStrokeWidth(5);
        oursPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        oursPaint.setColor(Color.GREEN);
    }

    public OursTank(float x, float y, float actionScopeWidth, float actionScopeHeight, Direction direction) {
        super(x, y, actionScopeWidth, actionScopeHeight, direction);
        initOursTank();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x + WIDTH / 2, y + HEIGHT / 2, WIDTH / 2 - PADDING_UP, oursPaint);
    }

    @Override
    protected void onFire(Missile missile) {
        if (null != hitHandler) {
            Log.i(TAG, "onFire: OursTank");
            hitHandler.onOursFire(missile);
        }
    }

    @Override
    protected void onHited() {

    }

    /**
     * 玩家控制移动
     * @param direction
     * @param walls
     */
    public void moveWithDirection(Direction direction, List<EnemyTank> tanks, List<Wall> walls) {
        if (null != direction && this.direction != direction) {
            setDirection(direction);
        }

        if (!touchTankOrWall(tanks, walls)) {
            move();
        }
    }

}
