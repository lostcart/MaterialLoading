package com.lostcart.materialloading;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.lostcart.materialloading.types.LoadingType;
import com.lostcart.materialloading.types.LoadingTypeSwoosh;


public class MaterialLoadingView extends View {

    private LoadingType loadingType;

    public MaterialLoadingView(Context context) {
        this(context, null);
    }

    public MaterialLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialLoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        loadingType = new LoadingTypeSwoosh();
    }

    public void setLoadingType(LoadingType loadingType){
        this.loadingType = loadingType;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        loadingType.onDraw(canvas);
        invalidate();
    }
}
