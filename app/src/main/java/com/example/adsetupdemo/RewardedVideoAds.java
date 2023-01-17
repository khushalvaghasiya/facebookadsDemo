package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.rewardedVideoAd;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.facebook.ads.AudienceNetworkAds;

public class RewardedVideoAds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video_ad);
        setTitle("Rewarded Video Ads");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        AudienceNetworkAds.initialize(this);

        Constant.showRewardedVideoAd(this);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> startActivity(new Intent(RewardedVideoAds.this, RewardedInterstitialAds.class)));
    }

    @Override
    protected void onDestroy() {
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
            rewardedVideoAd = null;
        }
        super.onDestroy();
    }
}