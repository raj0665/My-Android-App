package com.fyber.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.fyber.Fyber;
import com.fyber.annotations.FyberSDK;
import com.fyber.utils.FyberLogger;


@FyberSDK
public class MainActivity extends AppCompatActivity {

    Button button;
    private static final String appId = "38545";
    private static final String SECURITY_TOKEN = "38545";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);
        FyberLogger.enableLogging(true);
        //FyberLogger.enableLogging(BuildConfig.);
       Fyber.with(appId, this).withSecurityToken(SECURITY_TOKEN)

               .start();
//        Fyber.Settings settings = Fyber.with(appId, this).start();
//        settings.notifyUserOnCompletion(true)
//                .notifyUserOnReward(true);


        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.MyButton);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        NewActivity.class);
                startActivity(myIntent);

            }
        });
    }
//    BannerAdView bannerAdView2 = new BannerAdView(this)
//            .withListener(new BannerAdListener() {
//                @Override
//                public void onAdError(BannerAd bannerAd, String s) {
//
//                }
//
//                @Override
//                public void onAdLoaded(BannerAd bannerAd) {
//
//                }
//
//                @Override
//                public void onAdClicked(BannerAd bannerAd) {
//
//                }
//
//                @Override
//                public void onAdLeftApplication(BannerAd bannerAd) {
//
//                }
//            }).withNetworkSize(FacebookNetworkBannerSizes.BANNER_50).loadOnAttach();
//
//    LinearLayout parent2 = (LinearLayout)findViewById(R.id.linear);
//    parent2.addView(bann);
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
