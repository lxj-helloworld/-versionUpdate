package com.example.xiaojin20135.versionupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xiaojin20135.updatelibrary.UpdateChecker;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG,"msg.obj = " + msg.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateChecker updateChecker = new UpdateChecker(MainActivity.this,handler);
        String checkUrl = "http://www.topscomm.com:5000/app_download/package/chpcyDebug/update.json" + "?t="+System.currentTimeMillis();
        updateChecker.setCheckUrl(checkUrl);
        updateChecker.setShowAlert(false);
        updateChecker.checkForUpdates();
    }
}
