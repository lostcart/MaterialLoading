package com.lostcart.materialloading.types.modifiers;

import android.graphics.Canvas;

import com.lostcart.materialloading.types.modifiers.base.Modifier;
import com.lostcart.materialloading.utils.MathUtils;

public class SpinningModifier extends Modifier {
    // The current angle
    private float angle;

    // Should this dot spin round anti-clockwise?
    private boolean antiClockwise;

    // How many milliseconds should it take to do one rotation
    private long rotateSpeedMs = 1000;

    public SpinningModifier() {
    }

    public SpinningModifier(float startAngle, long rotateSpeedMs, boolean antiClockwise) {
        this.angle = startAngle;
        this.rotateSpeedMs = rotateSpeedMs;
        this.antiClockwise = antiClockwise;
    }

    @Override
    public void preDraw(Canvas canvas) {
        super.preDraw(canvas);
        canvas.rotate((antiClockwise ? -1 : 1) * angle, canvas.getWidth() / 2, canvas.getHeight() / 2);
    }

    @Override
    public void update(long diffTime) {
        angle = MathUtils.cycleTowards(angle, 360f, 360f * ((float) diffTime / rotateSpeedMs));
    }
}
