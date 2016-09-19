package br.org.eldorado.workshop2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {
    private static final String TAG = "ServiceActivity";
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startServiceTapped(View view) {
        serviceIntent = new Intent(this, WorkshopService.class);
        startService(serviceIntent);
    }

    public void stopServiceTapped(View view) {
        if (serviceIntent != null) {
            stopService(serviceIntent);
            serviceIntent = null;
        } else {
            Log.d(TAG, "Service not started");
        }
    }
}
