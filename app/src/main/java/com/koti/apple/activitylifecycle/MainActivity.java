package com.koti.apple.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: >>> ");
        Log.e(TAG, "onCreate: savedInstanceState >>> "+savedInstanceState);

        new Thread(new Runnable() {
            public void run() {
                //code
                try {
                    InstanceID instanceID = InstanceID.getInstance(getApplicationContext());

                    String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                            GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

                    Log.i(TAG, "GCM Registration Token: " + token);

                }catch (Exception e) {
                    Log.d(TAG, "Failed to complete token refresh", e);
                }
            }
        }).start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: >>> ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: >>> ");
    }
}
