package com.lostcart.materialloading.types;

import com.lostcart.materialloading.flibbels.Dot;
import com.lostcart.materialloading.flibbels.RoundySwoosh;
import com.lostcart.materialloading.types.modifiers.PulseModifier;
import com.lostcart.materialloading.types.modifiers.SpinningModifier;

/**
 * Dot that is circled by a changing size ring segment
 */
public class LoadingTypeSwoosh extends LoadingType {

    public LoadingTypeSwoosh() {
        addFlibbeler(new Flibbeler(new Dot(LoadingType.yellowColor, 1f), new PulseModifier()));
        addFlibbeler(new Flibbeler(new RoundySwoosh(LoadingType.blueColor), new SpinningModifier()));
    }
}
