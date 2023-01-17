package com.example.adsetupdemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
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
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.RewardedInterstitialAdListener;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.S2SRewardedInterstitialAdListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class Constant {

    public static InterstitialAd interstitialAd;
    public static RewardedInterstitialAd rewardedInterstitialAd;
    public static RewardedVideoAd rewardedVideoAd;
    public static AdView adView;
    public static NativeAd nativeAd;
    public static NativeBannerAd nativeBannerAd;
    public static LinearLayout customView;
    public static final String PLACEMENT_ID = "YOUR_PLACEMENT_ID";



    public static void showInterstitialAd(Activity activity) {
        interstitialAd = new InterstitialAd(activity.getBaseContext(), PLACEMENT_ID);
        InterstitialAdListener listener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.d("TAG", "displayed");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.d("TAG", "dismissed");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG", "Error: " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "adLoaded");
                interstitialAd.show();

            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "adClicked");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "loggingImpression");

            }
        };
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(listener).build());
    }

    public static void showRewardedInterstitialAd(Activity activity) {
        rewardedInterstitialAd = new RewardedInterstitialAd(activity.getBaseContext(), PLACEMENT_ID);
        RewardedInterstitialAdListener listener = new S2SRewardedInterstitialAdListener() {
            @Override
            public void onRewardServerFailed() {
                Log.d("TAG", "Rewarded Interstitial ad reward validation failed");
            }

            @Override
            public void onRewardServerSuccess() {
                Log.d("TAG", "Rewarded Interstitial ad reward validated");
            }

            @Override
            public void onRewardedInterstitialCompleted() {
                Log.d("TAG", "Completed");
            }

            @Override
            public void onRewardedInterstitialClosed() {
                Log.d("TAG", "Rewarded interstitial closed");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG", "Error " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "adLoaded");
                rewardedInterstitialAd.show(rewardedInterstitialAd
                        .buildShowAdConfig()
                        .withAppOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .build());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "adClicked");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "Logging Impression");
            }
        };
        RewardData rewardData = new RewardData("YOUR_USER_ID", "YOUR_REWARD");
        rewardedInterstitialAd.loadAd(rewardedInterstitialAd
                .buildLoadAdConfig()
                .withRewardData(rewardData)
                .withAdListener(listener)
                .build());
    }

    public static void showRewardedVideoAd(Activity activity) {
        rewardedVideoAd = new RewardedVideoAd(activity.getBaseContext(), PLACEMENT_ID);
        RewardedVideoAdListener listener = new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoCompleted() {
                Log.d("TAG", "videoCompleted");
            }

            @Override
            public void onRewardedVideoClosed() {
                Log.d("TAG", "videoClosed");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG", "Error: " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "adLoaded");
                rewardedVideoAd.show();

            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "adClicked");

            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "loggingImpression");

            }
        };
        RewardData rewardData = new RewardData("YOUR_USER_ID", "YOUR_REWARD");
        rewardedVideoAd.loadAd(rewardedVideoAd
                .buildLoadAdConfig()
                .withAdListener(listener)
                .withRewardData(rewardData)
                .build());
    }

    public static void showBannerAd(Context activity, LinearLayout layout) {
        adView = new AdView(activity, Constant.PLACEMENT_ID, AdSize.BANNER_HEIGHT_50);
        layout.addView(adView);
        adView.loadAd();
        AdSettings.setTestMode(true);

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG", "onError: " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "onLoaded");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "adClicked");

            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "loggingImpression");

            }
        };
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public static void showNativeAd(Activity activity, NativeAdLayout nativeAdLayout) {
        nativeAd = new NativeAd(activity, Constant.PLACEMENT_ID);
        NativeAdListener listener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.d("TAG", "mediaDownloaded");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG", "onError");
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "adLoaded");
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                nativeAd.unregisterView();
                LayoutInflater inflater = LayoutInflater.from(activity);
                customView = (LinearLayout) inflater.inflate(R.layout.custom_native_ad, nativeAdLayout, false);
                nativeAdLayout.addView(customView);

                LinearLayout adChoiceOptions = customView.findViewById(R.id.ad_choices_container);
                AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
                adChoiceOptions.addView(adOptionsView);

                TextView nativeAdTitle = customView.findViewById(R.id.native_ad_title);
                MediaView nativeAdMedia = customView.findViewById(R.id.native_ad_media);
                TextView sponsoredLabel = customView.findViewById(R.id.native_ad_sponsored_label);
                TextView nativeAdSocialContext = customView.findViewById(R.id.native_ad_social_context);
                TextView nativeAdBody = customView.findViewById(R.id.native_ad_body);
                Button nativeAdCallToAction = customView.findViewById(R.id.native_ad_call_to_action);

                nativeAdTitle.setText(nativeAd.getAdvertiserName());
                nativeAdBody.setText(nativeAd.getAdBodyText());
                nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
                sponsoredLabel.setText(nativeAd.getSponsoredTranslation());
                nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
                nativeAdCallToAction.setText(nativeAd.getAdCallToAction());

                List<View> clickableViews = new ArrayList<>();
                clickableViews.add(nativeAdTitle);
                clickableViews.add(nativeAdCallToAction);

                nativeAd.registerViewForInteraction(customView, nativeAdMedia, clickableViews);
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "adClicked");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "loggingImpression");
            }
        };
        nativeAd.loadAd(nativeAd
                .buildLoadAdConfig()
                .withAdListener(listener)
                .build());
    }

    public static void showNativeBannerAd(Activity activity, NativeAdLayout nativeAdLayout) {
        nativeBannerAd = new NativeBannerAd(activity, PLACEMENT_ID);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.d("TAG","downloaded");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("TAG","Error " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG","adLoaded");
                inflateAd(activity,nativeAdLayout);
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG","adClicked");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG","Logging impression");
            }
        };
        nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
    }

    public static void inflateAd(Activity activity, NativeAdLayout nativeAdLayout) {
        nativeBannerAd.unregisterView();

        LayoutInflater inflater = LayoutInflater.from(activity);
        customView = (LinearLayout) inflater.inflate(R.layout.custom_native_banner_ad,nativeAdLayout, false);
        nativeAdLayout.addView(customView);

        RelativeLayout adOptionsViewContainer = customView.findViewById(R.id.ad_choices_container_native_banner);
        AdOptionsView adOptionsView = new AdOptionsView(activity,nativeAd,nativeAdLayout);
        adOptionsViewContainer.addView(adOptionsView, 0);

        TextView adSponsored = customView.findViewById(R.id.adSponsored);
        MediaView adIcon = customView.findViewById(R.id.adIcon);
        TextView adTitle = customView.findViewById(R.id.adTitle);
        TextView adBody = customView.findViewById(R.id.adBody);
        Button adActionButton = customView.findViewById(R.id.adActionButton);

        adSponsored.setText(nativeBannerAd.getSponsoredTranslation());
        adTitle.setText(nativeBannerAd.getAdvertiserName());
        adBody.setText(nativeBannerAd.getAdBodyText());
        adActionButton.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        adActionButton.setText(nativeBannerAd.getAdCallToAction());

        List<View> clickableItems = new ArrayList<>();
        clickableItems.add(adIcon);
        clickableItems.add(adActionButton);

        nativeBannerAd.registerViewForInteraction(customView, adIcon, clickableItems);

    }

}
