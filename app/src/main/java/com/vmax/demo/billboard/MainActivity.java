package com.vmax.demo.billboard;


import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.vmax.android.ads.api.VmaxAdView;
import com.vmax.android.ads.common.VmaxAdListener;
import com.vmax.android.ads.exception.VmaxAdError;


/**Its Recommended To Use VMAX plugin For Android Studio To Add Your Dependencies
 and Manage Changes in AndroidManifest as Well as Proguard,
 However You Can Manually Do This By Referring To Our Documentation Or following this Demo Project  */


public class MainActivity extends AppCompatActivity {

    public   VmaxAdView vmaxAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadBillboard();

    }

    /** Method for adding Billboard Through XML */
    public void loadBillboard()
    {
        /** Container for Ad*/
       vmaxAdView = (VmaxAdView) findViewById(R.id.billboard_adview);

        /** To Fetch Your AdvId you can check your device's Google settings under ads subMenu Or You can Run this app Once and check
         * the logs for 'AdRequested with url' under the tag vmax, from the url your Advid
         * would be one of the parameters in the post request eg. advid=2cf626f0-08ac-4a4d-933c-00ecd0256cf4  */

     /** DON'T INCLUDE vmaxAdView.setTestDevices() WHILE GOING LIVE WITH YOUR PROJECT AS THIS SERVES ONLY TEST ADS;*/
        vmaxAdView.setTestDevices(VmaxAdView.TEST_via_ADVID,"<REPLACE WITH YOUR ADVID>");


        vmaxAdView.loadAd();

    }




    /** Handle vmaxAdView object for Activity Lifecycle changes */

    @Override
    protected void onPause() {
        if (vmaxAdView != null) {
            /** To Pause Refresh Of The Ad While Activity Isn't in Foreground */
            vmaxAdView.onPause();
        }

        super.onPause();
    }
    @Override
    protected void onResume() {
        if (vmaxAdView != null) {
            /** To Resume Refresh Of The Ad While Activity Comes Back To Foreground */

            vmaxAdView.onResume();
        }
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        if (vmaxAdView != null) {
       /** To Destroy vmaxAdView when Activity Is No Longer Available  */
            vmaxAdView.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (vmaxAdView != null) {

            /** To Reconfigure vmaxAdview According To Configuration Changes*/
            vmaxAdView.onConfigurationChanged();
        }

    }

}
