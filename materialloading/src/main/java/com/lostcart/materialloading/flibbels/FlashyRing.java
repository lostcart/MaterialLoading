package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.lostcart.materialloading.flibbels.base.Flibbel;
import com.lostcart.materialloading.types.LoadingType;
import com.lostcart.materialloading.utils.MathUtils;

public class FlashyRing extends Flibbel {
    private Ring[] rings;

    public FlashyRing(long pulseSpeed, long pulseHold, int... colors) {
        super(LoadingType.blueColor);
        this.rings = new Ring[colors.length];

        for(int i=0; i<rings.length; i++){
            rings[i] = new Ring(colors[i], pulseSpeed, pulseHold);
        }
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        rings[currentIndex].draw(canvas, diffTime);
    }

    @Override
    public void update(long diffTime) {
    }
}
