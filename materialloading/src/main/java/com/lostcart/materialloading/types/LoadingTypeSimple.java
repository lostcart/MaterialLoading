package com.lostcart.materialloading.types;

import com.lostcart.materialloading.flibbels.Dot;
import com.lostcart.materialloading.types.modifiers.PulseModifier;
import com.lostcart.materialloading.types.modifiers.SpinningModifier;

/**
 * Dot that is circled by a changing size ring segment
 */
public class LoadingTypeSimple extends LoadingType {

    public LoadingTypeSimple() {
        addFlibbeler(new Flibbeler(new Dot(LoadingType.blueColor, 0f), new SpinningModifier()));
        addFlibbeler(new Flibbeler(new Dot(LoadingType.redColor, 0f), new SpinningModifier(0, 1000, true)));
        addFlibbeler(new Flibbeler(new Dot(LoadingType.greenColor, 0f), new SpinningModifier(), new PulseModifier()));
    }
}
