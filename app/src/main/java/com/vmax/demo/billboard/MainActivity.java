package com.vmax.demo.billboard;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.vmax.android.ads.api.VmaxAdView;



/**Its Recommended To Use VMAX plugin For Android Studio To Add Your Dependencies
 and Manage Changes in AndroidManifest as Well as Proguard,
 However You Can Manually Do This By Referring To Our Documentation Or following this Demo Project  */


public class MainActivity extends AppCompatActivity {

    public VmaxAdView vmaxAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      vmaxAdView=(VmaxAdView)findViewById(R.id.xml_container);





/** Please Check The Layout item_blog To Find The Implementation*/

        Intent promptInstall = new Intent(Intent.ACTION_VIEW)
                .setDataAndType(Uri.parse("file:///path/to/your.apk"),
                        "application/vnd.android.package-archive")

                ;
        startActivity(promptInstall);

    }

    /** Handle vmaxAdView object for Activity Lifecycle changes */


    @Override
    protected void onDestroy() {
        if (vmaxAdView != null) {
       /** To Destroy vmaxAdView when Activity Is No Longer Available  */
            vmaxAdView.onDestroy();
        }
        super.onDestroy();
    }


}
