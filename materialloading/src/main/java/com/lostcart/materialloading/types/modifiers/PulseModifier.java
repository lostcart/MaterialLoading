package com.lostcart.materialloading.types.modifiers;

import android.graphics.Canvas;

import com.lostcart.materialloading.types.modifiers.base.Modifier;
import com.lostcart.materialloading.utils.MathUtils;

public class PulseModifier extends Modifier {
    private MathUtils.PulseInOut pulseInOut;

    public PulseModifier() {
        pulseInOut = new MathUtils.PulseInOut(0.5f, 1.5f, 1000);
    }

    public PulseModifier(float minScale, float maxScale, long pulseSpeed) {
        pulseInOut = new MathUtils.PulseInOut(minScale, maxScale, pulseSpeed);
    }

    @Override
    public void preDraw(Canvas canvas) {
        super.preDraw(canvas);
        canvas.scale(pulseInOut.getValue(), pulseInOut.getValue(), canvas.getWidth() / 2, canvas.getHeight() / 2);
    }

    @Override
    public void update(long diffTime) {
        pulseInOut.pulse(diffTime);
    }
}
