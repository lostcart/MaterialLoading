package com.lostcart.materialloading.types;

import com.lostcart.materialloading.flibbels.Ring;

import java.util.ArrayList;
import java.util.List;

/**
 * Dot that is circled by a changing size ring segment
 */
public class LoadingTypeJazzyRings extends LoadingType {

    List<Ring> rings = new ArrayList<>();

    public LoadingTypeJazzyRings() {
        addFlibbeler(new Flibbeler(new Ring(LoadingType.greenColor)));

        rings.add(new Ring(LoadingType.yellowColor, 500, 1000));
        rings.add(new Ring(LoadingType.greenColor, 500, 1000));

        for (int i = 0; i < rings.size(); i++) {
            addFlibbeler(new Flibbeler(rings.get(i)));

            final Ring nextRing = rings.get(i < rings.size() - 1 ? i + 1 : 0);
            rings.get(i).setOnFinishListener(new Ring.OnFinishListener() {
                @Override
                public void finish() {
                    nextRing.start();
                }
            });
        }

        rings.get(0).start();

        // addFlibbeler(new Flibbeler(new Ring(LoadingType.redColor, 500, 500, 1000)));
        // addFlibbeler(new Flibbeler(new Ring(LoadingType.blueColor, 500, 500, 1500)));
    }
}
