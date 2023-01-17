package com.example.adsetupdemo;

import static com.example.adsetupdemo.Constant.rewardedInterstitialAd;
import static com.example.adsetupdemo.Constant.showRewardedInterstitialAd;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.ads.AudienceNetworkAds;

public class RewardedInterstitialAds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewareded_interstitial_ads);
        setTitle("Rewarded Interstitial Ads");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        AudienceNetworkAds.initialize(this);

        showRewardedInterstitialAd(this);
    }

    @Override
    protected void onDestroy() {
        if (rewardedInterstitialAd != null) {
            rewardedInterstitialAd.destroy();
            rewardedInterstitialAd = null;
        }
        super.onDestroy();
    }
}