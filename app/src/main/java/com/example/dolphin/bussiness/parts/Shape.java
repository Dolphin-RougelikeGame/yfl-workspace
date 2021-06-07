package com.example.dolphin.bussiness.parts;

import android.graphics.Canvas;

import java.io.FileNotFoundException;

/**
 * Created by THINK on 2018/8/8.
 */

public interface Shape {

    void draw(Canvas canvas) throws FileNotFoundException;
}
