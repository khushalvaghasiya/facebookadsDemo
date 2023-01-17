package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.nativeAd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.NativeAdLayout;

public class NativeAds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ads);
        setTitle("Native Ads");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AudienceNetworkAds.initialize(this);
        NativeAdLayout nativeAdLayout = findViewById(R.id.native_ad_container);

        Constant.showNativeAd(this, nativeAdLayout);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> startActivity(new Intent(NativeAds.this, NativeBannerAds.class)));
    }

    @Override
    public void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }
}