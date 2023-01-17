package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.nativeBannerAd;
import static com.example.adsetupdemo.Constant.showNativeBannerAd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;
import java.util.List;

public class NativeBannerAds extends AppCompatActivity {

    private NativeAdLayout nativeAdLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_banner_ads);
        setTitle("Native Banner Ads");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AudienceNetworkAds.initialize(this);
        nativeAdLayout = findViewById(R.id.nativeAdLayout);

        showNativeBannerAd(this, nativeAdLayout);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(NativeBannerAds.this, RewardedVideoAds.class));
        });

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            showNativeBannerAd(this, nativeAdLayout);
        },10000);
    }

    @Override
    protected void onDestroy() {
        if (nativeBannerAd != null) {
            nativeBannerAd.destroy();
        }
        super.onDestroy();
    }
}