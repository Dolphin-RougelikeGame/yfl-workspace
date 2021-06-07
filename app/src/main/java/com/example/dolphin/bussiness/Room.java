package com.example.dolphin.bussiness;

import android.graphics.Canvas;

import com.example.dolphin.bussiness.parts.Shape;

import java.util.Random;

public class Room implements Shape {
    private float RoomSizeParam;
    private float RoomShapeParam;
    private float RoomRejectParam;
    private float RoomSize;
    private int RoomShape;
    private int RoomReject;
    private Random random = new Random();

    public Room(float RoomSizeParam, float RoomShapeParam, float RoomRejectParam) {
        this.RoomSizeParam = RoomSizeParam;
        this.RoomShapeParam = RoomShapeParam;
        this.RoomRejectParam = RoomRejectParam;
    }

    public float RoomSizeFeature() {
        int random1 = random.nextInt(38);
        this.RoomSize = RoomSizeParam * (float) random1 + 70;
        return RoomSize;
//        float RoomSize = 80f;
//        return RoomSize;
    }

    public boolean RoomShapeFeature() {
        int random2 = random.nextInt(10);
        // this.RoomShape = (int) (3 + (float) (random2) * RoomShapeParam);
        if (random2 - 5 > 0) {
            return false;
        }
        else {
            return true;
        }
        // return RoomShape;
    }

    public int RoomRejectFeature() {
        int random3 = random.nextInt(60);
        this.RoomReject = (int) (RoomRejectParam * (float) random3) + 120;
        return RoomReject;
    }

    @Override
    public void draw(Canvas canvas) {
    }
}
