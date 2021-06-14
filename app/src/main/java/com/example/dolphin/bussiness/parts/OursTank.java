package com.example.dolphin.bussiness.parts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import com.example.dolphin.R;
import com.example.dolphin.bussiness.Direction;

import java.util.ArrayList;
import java.util.List;

public class OursTank extends Tank {
    private Paint oursPaint;

    int state;

    Animation animation;

    public void initOursTank(Context context) {
        oursPaint = new Paint();

        oursPaint.setStrokeWidth(5);
        oursPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        oursPaint.setColor(Color.GREEN);

        animation = new Animation(context);
        state = 0;
    }

    public OursTank(float x, float y, float actionScopeWidth, float actionScopeHeight, Direction direction, Context context) {
        super(x, y, actionScopeWidth, actionScopeHeight, direction);
        initOursTank(context);
    }

    public void draw(Canvas canvas){
        switch (state){
            case 0:
                canvas.drawBitmap(animation.nextFrame(), x, y, new Paint());
                break;
            default:break;
        }
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

    class Animation{
        List<Bitmap> bitmapList;

        int frameIndex;

        Animation(Context context){
            bitmapList = new ArrayList<>();
            addBitmapToList(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_1));
            addBitmapToList(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_2));
            addBitmapToList(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_3));
            addBitmapToList(BitmapFactory.decodeResource(context.getResources(), R.drawable.shark_move_4));
            frameIndex = 0;
        }

        void addBitmapToList(Bitmap bitmap){
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            float scaleWidth = WIDTH / width;
            float scaleHeight = HEIGHT / height;
            // 取得想要缩放的matrix参数
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            // 得到新的图片
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmapList.add(bitmap);
        }

        Bitmap nextFrame(){
            frameIndex = (frameIndex + 1) % 12;
            return bitmapList.get(frameIndex / 3);
        }
    }

}
