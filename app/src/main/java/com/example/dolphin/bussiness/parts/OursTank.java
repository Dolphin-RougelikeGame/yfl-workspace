package com.example.dolphin.bussiness.parts;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.dolphin.R;
import com.example.dolphin.bussiness.Direction;
import com.example.dolphin.bussiness.animation.FrameAnimation;

import java.util.List;

public class OursTank extends Tank {
    private Paint oursPaint;

    // 状态：移动、攻击、死亡等，0为移动，其他还没写

    FrameAnimation moveAnimation;
    FrameAnimation idleAnimation;

    FrameAnimation currAnimation;

    public void initOursTank(Context context) {
        oursPaint = new Paint();

        oursPaint.setStrokeWidth(5);
        oursPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        oursPaint.setColor(Color.GREEN);

        moveAnimation = new FrameAnimation(WIDTH, HEIGHT, 3);
        moveAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_1));
        moveAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_2));
        moveAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_3));
        moveAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_4));

        idleAnimation = new FrameAnimation(WIDTH, HEIGHT, 3);
        idleAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.dolphin_idle_1));
        idleAnimation.addFrame(BitmapFactory.decodeResource(context.getResources(), R.drawable.dolphin_idle_2));

        setState(Tank.IDLE);

    }

    public OursTank(float x, float y, float actionScopeWidth, float actionScopeHeight, Direction direction, Context context) {
        super(x, y, actionScopeWidth, actionScopeHeight, direction);
        initOursTank(context);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(currAnimation.nextFrame(), x, y, new Paint());
    }

    public void setState(int state){
        this.state = state;
        switch (state){
            case Tank.IDLE:
                currAnimation = idleAnimation;
                break;
            case Tank.MOVE:
                currAnimation = moveAnimation;
                break;
        }
        currAnimation.resetAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(x + WIDTH / 2, y + HEIGHT / 2, WIDTH / 2 - PADDING_UP, oursPaint);
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
