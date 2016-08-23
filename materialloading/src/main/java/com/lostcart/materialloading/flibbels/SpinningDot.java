package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;

import com.lostcart.materialloading.utils.MathUtils;

/**
 * This flibbel is a dot that spins round in a circle, it can move towards the centre and back again
 * it can go anti clockwise, you can set it's start angle and the speed at which it spins round
 */
public class SpinningDot extends Flibbel {
    // Radius of the dot as a fraction of the canvas size
    private float dotRadius = 0.1f;

    private MathUtils.PulseInOut pulseInOutValue;

    public SpinningDot(int color) {
        this(color, 0);
    }

    public SpinningDot(int color, long pulseInOutSpeedMs) {
        super(color);
        pulseInOutValue = new MathUtils.PulseInOut(0f, 1f, pulseInOutSpeedMs);
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        float horizontalAdjustment = pulseInOutValue.getValue() * ((width / 2) - (dotRadius * width * 3));
        canvas.drawCircle((dotRadius * width) + horizontalAdjustment, height / 2, dotRadius * width, paint);
    }

    @Override
    public void setup() {
    }

    @Override
    public void update(long diffTime) {
        pulseInOutValue.pulse(diffTime);
    }
}
