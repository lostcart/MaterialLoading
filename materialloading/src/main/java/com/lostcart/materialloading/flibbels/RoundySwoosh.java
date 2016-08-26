package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.lostcart.materialloading.flibbels.base.Flibbel;
import com.lostcart.materialloading.utils.MathUtils;

public class RoundySwoosh extends Flibbel {
    private static final float strokeWidth = 0.15f;

    private long pulseSpeed = 1000;

    private RectF containerRectF;

    private MathUtils.PulseInOut pulseInOut;

    private int minSweepAngle = 10;
    private int maxSweepAngle = 300;

    public RoundySwoosh(int color) {
        super(color);
    }

    @Override
    public void setup() {
        float strokeWidthValue = strokeWidth * width;

        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeWidth(strokeWidthValue);
        paint.setStyle(Paint.Style.STROKE);

        containerRectF = new RectF(strokeWidthValue, strokeWidthValue, width - strokeWidthValue, height - strokeWidthValue);
        pulseInOut = new MathUtils.PulseInOut(minSweepAngle, maxSweepAngle, pulseSpeed);
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        canvas.drawArc(containerRectF, 0, pulseInOut.getValue(), false, paint);
    }

    @Override
    public void update(long diffTime) {
        pulseInOut.pulse(diffTime);
    }
}
