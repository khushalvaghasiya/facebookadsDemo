package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.showInterstitialAd;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.facebook.ads.AudienceNetworkAds;

public class InterstitialAdView extends AppCompatActivity {

    private int click = 0;
    Button btnShowAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad_view);
        setTitle("Interstitial Ads");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        btnShowAd = findViewById(R.id.btnShowAd);
        AudienceNetworkAds.initialize(this);


        btnShowAd.setOnClickListener(view -> {
            Log.d("TAG", "Click " + click);
            click++;
            if (click == 4) {
                showInterstitialAd(this);
                click = 0;
            }
        });

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> startActivity(new Intent(InterstitialAdView.this, NativeAds.class)));
    }

    @Override
    protected void onDestroy() {
       if (Constant.interstitialAd != null) {
           Constant.interstitialAd.destroy();
           Constant.interstitialAd = null;
       }
        super.onDestroy();
    }
}