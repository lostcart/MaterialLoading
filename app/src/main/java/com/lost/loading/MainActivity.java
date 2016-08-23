package com.lost.loading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lostcart.materialloading.MaterialLoadingView;
import com.lostcart.materialloading.types.LoadingTypeSimple;
import com.lostcart.materialloading.types.LoadingTypeSwoosh;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialLoadingView topMaterialLoadingView = (MaterialLoadingView) findViewById(R.id.main_loadingview_top);
        MaterialLoadingView middleMaterialLoadingView = (MaterialLoadingView) findViewById(R.id.main_loadingview_middle);
        MaterialLoadingView bottomMaterialLoadingView = (MaterialLoadingView) findViewById(R.id.main_loadingview_bottom);

        topMaterialLoadingView.setLoadingType(new LoadingTypeSimple());
        middleMaterialLoadingView.setLoadingType(new LoadingTypeSwoosh());
        bottomMaterialLoadingView.setLoadingType(new LoadingTypeSimple());
    }
}
