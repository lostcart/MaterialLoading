package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;

import com.lostcart.materialloading.flibbels.base.Flibbel;

public class Dot extends Flibbel {
    private float dotRadius = 0.1f;

    private float horizontalPosition;

    public Dot(int color) {
        this(color, 0.5f);
    }

    public Dot(int color, float horizontalPosition){
        super(color);
        this.horizontalPosition = horizontalPosition;
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        canvas.drawCircle((dotRadius*width) + (horizontalPosition * ((width/2) - (dotRadius*width))), height / 2, dotRadius * width, paint);
    }

    @Override
    public void setup() {

    }

    @Override
    public void update(long currentTime) {
    }
}
