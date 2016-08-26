package com.lostcart.materialloading.flibbels;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.lostcart.materialloading.flibbels.base.Flibbel;
import com.lostcart.materialloading.utils.MathUtils;

public class Ring extends Flibbel {
    private float strokeWidth = 0.2f;

    private RectF containerRectF;

    private MathUtils.PulseOutAndHold pulseOutAndHold;

    private OnFinishListener onFinishListener;

    private boolean start;

    public Ring(int color, long pulseSpeed, long pulseHold) {
        super(color);
        pulseOutAndHold = new MathUtils.PulseOutAndHold(0, 1, pulseSpeed, pulseHold);
    }

    public Ring(int color) {
        this(color, 0, 0);
    }

    @Override
    public void setup() {
        strokeWidth = strokeWidth * width;

        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);

        containerRectF = new RectF(strokeWidth / 2, strokeWidth / 2, width - (strokeWidth / 2), height - (strokeWidth / 2));
    }

    @Override
    public void draw(Canvas canvas, long diffTime) {
        super.draw(canvas, diffTime);
        canvas.drawArc(containerRectF, 0, 360, false, paint);
    }

    @Override
    public void update(long diffTime) {
        if (start) {
            if (pulseOutAndHold.pulse(diffTime)) {
                start = false;
                paint.setAlpha(0);
                onFinishListener.finish();
            }
            else {
                paint.setStrokeWidth(strokeWidth * (pulseOutAndHold.getValue()));
                containerRectF.set(strokeWidth - (paint.getStrokeWidth() / 2), strokeWidth - (paint.getStrokeWidth() / 2), (width - strokeWidth) + (paint.getStrokeWidth() / 2), (height - strokeWidth) + (paint.getStrokeWidth() / 2));
            }
        }
    }

    public void start() {
        paint.setAlpha(255);
        start = true;
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public interface OnFinishListener {
        void finish();
    }
}
