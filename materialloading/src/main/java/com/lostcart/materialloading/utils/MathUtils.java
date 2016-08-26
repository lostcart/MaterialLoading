package com.lostcart.materialloading.utils;

import android.util.Log;

public class MathUtils {

    /**
     * Move towards a value, once we get there reset the value back to 0, plus what ever was left over
     *
     * @param value
     * @param destination
     * @param amount
     * @return
     */
    public static float cycleTowards(float value, final float destination, final float amount) {
        value += amount;
        if (value > destination) {
            // TODO: this shouldn't be zero it should be zero plus the remainder over the destination value
            value -= destination;
        }
        return value;
    }

    public static class PulseOutAndHold {
        final float startValue;
        final float endValue;
        private float pulseSpeed;
        private final long holdTime;
        private long holdTimeCount;
        private float value;

        public PulseOutAndHold(final float startValue, final float endValue, final float pulseSpeed, final long holdTime) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.pulseSpeed = pulseSpeed;
            this.holdTime = holdTime;
            value = startValue;
        }

        public boolean pulse(final float diffTime) {
            float adjustAmount = getRange() * diffTime / pulseSpeed;

            value += adjustAmount;

            if (value > endValue) {
                value = endValue;
                holdTimeCount += diffTime;

                if(holdTimeCount > holdTime){
                    Log.d("LUKELUKE", "finish holding:"+ holdTimeCount);
                    holdTimeCount = 0;
                    value = startValue;
                    return true;
                }
            }
            return false;
        }

        public float getValue() {
            return value;
        }

        private float getRange() {
            return endValue - startValue;
        }
    }

    public static class PulseInOut {
        boolean flip;

        final float startValue;
        final float endValue;

        private float value;

        private float pulseSpeed;

        public PulseInOut(final float startValue, final float endValue, final float pulseSpeed) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.pulseSpeed = pulseSpeed;
            value = startValue;
        }

        public void pulse(final float diffTime) {
            if (pulseSpeed != 0) {
                float adjustAmount = getRange() * diffTime / pulseSpeed;
                value += ((flip ? -1 : 1) * adjustAmount);
                if (value > endValue) {
                    value = endValue - (value - endValue);
                    flip = true;
                } else if (value < startValue) {
                    value = startValue + (startValue - value);
                    flip = false;
                }
            }
        }

        public float getValue() {
            return value;
        }

        private float getRange() {
            return endValue - startValue;
        }
    }
}
