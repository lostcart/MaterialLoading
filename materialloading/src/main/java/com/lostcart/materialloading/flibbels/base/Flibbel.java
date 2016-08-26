package com.lostcart.materialloading.flibbels.base;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Flibbel {

    protected int color;

    protected float width;
    protected float height;

    private boolean setup;

    protected Paint paint;

    public Flibbel(int color) {
        setColor(color);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
    }
    
    public void draw(Canvas canvas, long diffTime) {
        if (!setup) {
            width = canvas.getWidth();
            height = canvas.getHeight();
            setup();
            setup = true;
        }
    }

    public abstract void setup();

    public abstract void update(long diffTime);


    public void setColor(int color) {
        this.color = color;
    }
}
