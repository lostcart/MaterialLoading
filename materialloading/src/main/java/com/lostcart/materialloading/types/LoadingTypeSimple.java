package com.lostcart.materialloading.types;

import com.lostcart.materialloading.flibbels.SpinningDot;
import com.lostcart.materialloading.types.modifiers.SpinningModifier;

/**
 * Dot that is circled by a changing size ring segment
 */
public class LoadingTypeSimple extends LoadingType {

    public LoadingTypeSimple() {
        //    addFlibbel(new StaticDot(LoadingType.yellowColor));
        addFlibbeler(new Flibbeler(new SpinningDot(LoadingType.blueColor), new SpinningModifier()));
        addFlibbeler(new Flibbeler(new SpinningDot(LoadingType.redColor, 1000), new SpinningModifier(0, 1000, true)));
    }
}
