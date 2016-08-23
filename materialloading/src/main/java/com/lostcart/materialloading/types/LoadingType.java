package com.lostcart.materialloading.types;

import android.graphics.Canvas;

import com.lostcart.materialloading.flibbels.Flibbel;
import com.lostcart.materialloading.types.modifiers.Modifier;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.rgb;

public abstract class LoadingType {

    public static int redColor = rgb(244, 67, 54);
    public static int blueColor = rgb(33, 150, 243);
    public static int yellowColor = rgb(255, 193, 7);
    public static int greenColor = rgb(76, 175, 80);

    protected long lastUpdateTime;

    protected List<Flibbeler> flibbelers = new ArrayList<>();

    public class Flibbeler {
        private Flibbel flibbel;
        private Modifier modifier;

        public Flibbeler(Flibbel flibbel, Modifier modifier) {
            this.flibbel = flibbel;
            this.modifier = modifier;
        }

        public Flibbel getFlibbel() {
            return flibbel;
        }

        public Modifier getModifier() {
            return modifier;
        }
    }

    public void onDraw(Canvas canvas) {
        long currentTime = System.currentTimeMillis();

        for (Flibbeler flibbeler : flibbelers) {
            if (lastUpdateTime != 0) {
                flibbeler.getFlibbel().update(currentTime - lastUpdateTime);
                if(flibbeler.getModifier()!=null) {
                    flibbeler.getModifier().update(currentTime - lastUpdateTime);
                }
            }
            if (flibbeler.getModifier() != null) {
                flibbeler.getModifier().preDraw(canvas);
            }
            flibbeler.getFlibbel().draw(canvas, currentTime - lastUpdateTime);
            if (flibbeler.getModifier() != null) {
                flibbeler.getModifier().postDraw(canvas);
            }
        }

        lastUpdateTime = currentTime;
    }

    public void addFlibbeler(Flibbeler flibbeler) {
        flibbelers.add(flibbeler);
    }
}
