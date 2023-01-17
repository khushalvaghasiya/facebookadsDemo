package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.adView;
import static com.example.adsetupdemo.Constant.showBannerAd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.ads.AudienceNetworkAds;


public class BannerAds extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ads);
        setTitle("Banner Ads");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        AudienceNetworkAds.initialize(this);
        LinearLayout layout = findViewById(R.id.banner_container);
        showBannerAd(this,layout);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> startActivity(new Intent(this, InterstitialAdView.class)));
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
