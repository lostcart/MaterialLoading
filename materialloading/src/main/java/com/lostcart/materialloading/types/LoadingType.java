package com.lostcart.materialloading.types;

import android.graphics.Canvas;

import com.lostcart.materialloading.flibbels.base.Flibbel;
import com.lostcart.materialloading.types.modifiers.base.Modifier;

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
        private Modifier[] modifiers;

        public Flibbeler(Flibbel flibbel, Modifier... modifiers) {
            this.flibbel = flibbel;
            this.modifiers = modifiers;
        }

        public Flibbel getFlibbel() {
            return flibbel;
        }

        public Modifier[] getModifiers() {
            return modifiers;
        }
    }

    public void onDraw(Canvas canvas) {
        long currentTime = System.currentTimeMillis();

        for (Flibbeler flibbeler : flibbelers) {
            if (lastUpdateTime != 0) {
                flibbeler.getFlibbel().update(currentTime - lastUpdateTime);
                if (flibbeler.getModifiers() != null) {
                    for (Modifier modifier : flibbeler.getModifiers()) {
                        modifier.update(currentTime - lastUpdateTime);
                    }
                }
            }
            if (flibbeler.getModifiers() != null) {
                for (Modifier modifier : flibbeler.getModifiers()) {
                    modifier.preDraw(canvas);
                }
            }
            flibbeler.getFlibbel().draw(canvas, currentTime - lastUpdateTime);
            if (flibbeler.getModifiers() != null) {
                for (Modifier modifier : flibbeler.getModifiers()) {
                    modifier.postDraw(canvas);
                }
            }
        }

        lastUpdateTime = currentTime;
    }

    public void addFlibbeler(Flibbeler flibbeler) {
        flibbelers.add(flibbeler);
    }
}
