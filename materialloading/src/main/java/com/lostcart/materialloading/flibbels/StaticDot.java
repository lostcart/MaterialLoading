package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;

public class StaticDot extends Flibbel {
    private float dotRadius = 0.1f;

    public StaticDot(int color) {
        super(color);
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        canvas.drawCircle(width / 2, height / 2, dotRadius * width, paint);
    }

    @Override
    public void setup() {

    }

    @Override
    public void update(long currentTime) {
    }
}
