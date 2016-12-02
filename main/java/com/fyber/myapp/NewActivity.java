package com.fyber.myapp;

/**
 * Created by rchoudhury on 05/11/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.fyber.ads.AdFormat;
import com.fyber.ads.banners.BannerAd;
import com.fyber.ads.banners.BannerAdListener;
import com.fyber.ads.banners.BannerAdView;
import com.fyber.annotations.FyberSDK;
import com.fyber.mediation.admob.banner.AdMobNetworkBannerSizes;
import com.fyber.mediation.configs.AdMobConfigs;
import com.fyber.mediation.configs.FacebookConfigs;
import com.fyber.mediation.facebook.banner.FacebookNetworkBannerSizes;
import com.fyber.requesters.InterstitialRequester;
import com.fyber.requesters.OfferWallRequester;
import com.fyber.requesters.RequestCallback;
import com.fyber.requesters.RequestError;
import com.fyber.requesters.RewardedVideoRequester;
//import com.fyber.ads.
@FacebookConfigs(
        bannerPlacementId = "480962338767866_480963318767768",

        testDeviceHash = "fd695c7a9f79dadb299f1a51628ca687"

)

@AdMobConfigs(
        adUnitId = "ca-app-pub-2059698156720573/8778558647"
)

@FyberSDK
public class NewActivity extends Activity implements RequestCallback {
    Button button1;
    Button button2;
    Button button3;
    Button button4;

//     RequestCallback requestCallback = new RequestCallback() {
//         @Override
//         public void onAdAvailable(Intent intent) {
//
//         }
//
//         @Override
//         public void onAdNotAvailable(AdFormat adFormat) {
//
//         }
//
//         @Override
//         public void onRequestError(RequestError requestError) {
//
//         }
//     };







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.new_activity);
        //Banner request
        BannerAdView bannerAdView = new BannerAdView(this)
                .withListener(new BannerAdListener() {
                    @Override
                    public void onAdError(BannerAd bannerAd, String s) {

                    }

                    @Override
                    public void onAdLoaded(BannerAd bannerAd) {

                    }

                    @Override
                    public void onAdClicked(BannerAd bannerAd) {

                    }

                    @Override
                    public void onAdLeftApplication(BannerAd bannerAd) {

                    }
                }).withNetworkSize(AdMobNetworkBannerSizes.SMART_BANNER).loadOnAttach();

        RelativeLayout parent = (RelativeLayout)findViewById(R.id.relative);
        parent.addView(bannerAdView);

        BannerAdView bannerAdView1 = new BannerAdView(this)
                .withListener(new BannerAdListener() {
                    @Override
                    public void onAdError(BannerAd bannerAd, String s) {

                    }

                    @Override
                    public void onAdLoaded(BannerAd bannerAd) {

                    }

                    @Override
                    public void onAdClicked(BannerAd bannerAd) {

                    }

                    @Override
                    public void onAdLeftApplication(BannerAd bannerAd) {

                    }
                }).withNetworkSize(FacebookNetworkBannerSizes.BANNER_50).loadOnAttach();

        RelativeLayout parent1 = (RelativeLayout)findViewById(R.id.relative1);
        parent1.addView(bannerAdView1);



        //RelativeLayout parent = (RelativeLayout)findViewById(R.id.relative);

        //Requesting Interstitial Ad
        button3 = (Button)findViewById(R.id.interstitialbutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialRequester.create(new RequestCallback() {

                    @Override
                    public void onAdAvailable(Intent intent) {
                        System.out.println("Interstitial Available");
                        startActivityForResult(intent, 38545);


                    }

                    @Override
                    public void onAdNotAvailable(AdFormat adFormat) {
                        System.out.println("Interstitial not available");

                    }

                    @Override
                    public void onRequestError(RequestError requestError) {
                        System.out.println(" Interstitial Request error");
                    }
                }).request(getApplicationContext());

            }
        });

        //Requesting Offerwall
    button2 = (Button)findViewById(R.id.offerwallbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OfferWallRequester.create(new RequestCallback() {

                    @Override
                    public void onAdAvailable(Intent intent) {
                        System.out.println("Offer available");
                        startActivityForResult(intent, 38545);


                    }

                    @Override
                    public void onAdNotAvailable(AdFormat adFormat) {
                        System.out.println("Offer not available");

                    }

                    @Override
                    public void onRequestError(RequestError requestError) {
                        System.out.println("Request error");
                    }
                }).request(getApplicationContext());

            }
        });

        //Requesting Rewarded Video
    button1 = (Button) findViewById(R.id.rbutton);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                RewardedVideoRequester.create(new RequestCallback() {

                    @Override
                    public void onAdAvailable(Intent intent) {
                        System.out.println("Video available");
                        startActivityForResult(intent, 38545);


                    }

                    @Override
                    public void onAdNotAvailable(AdFormat adFormat) {
                        System.out.println("Video not available");
                    }

                    @Override
                    public void onRequestError(RequestError requestError) {
                        System.out.println("Request error");
                    }
                }).request(getApplicationContext());

            }


        });

    }


    @Override
    public void onAdAvailable(Intent intent) {
        startActivityForResult(intent, 38545);
    }

    @Override
    public void onAdNotAvailable(AdFormat adFormat) {

    }

    @Override
    public void onRequestError(RequestError requestError) {

    }


}






