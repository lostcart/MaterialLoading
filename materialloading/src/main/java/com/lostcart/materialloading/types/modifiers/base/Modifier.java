package com.lostcart.materialloading.types.modifiers.base;

import android.graphics.Canvas;

public abstract class Modifier {
    public void preDraw(Canvas canvas){
        canvas.save();
    }
    public void postDraw(Canvas canvas){
        canvas.restore();
    }
    public abstract void update(long diffTime);
}
