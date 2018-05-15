package com.example.xiaojin20135.versionupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.xiaojin20135.updatelibrary.AppVersion;
import com.example.xiaojin20135.updatelibrary.UpdateChecker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    private TextView check_result_Tv;
    //声明Handler对象，接收版本号检查结果
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG,"msg.obj = " + msg.obj.toString());
            if(msg.what == AppVersion.CONNECTFAILED){
                check_result_Tv.setText("服务端升级文件访问失败");
            }else if(msg.what == AppVersion.CONNECTSUCCESS){
                check_result_Tv.setText("服务端升级文件访问成功");
            }else if(msg.what == AppVersion.NEW_VERSION){
                check_result_Tv.setText("发现新版本 : " + msg.obj.toString());
            }else if(msg.what == AppVersion.ALREADY_NEW){
                check_result_Tv.setText("当前已是最新版本");
            }else {
                check_result_Tv.setText("unknown message");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_result_Tv = (TextView)findViewById(R.id.check_result_Tv);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.check_btn){
            UpdateChecker.apkFileName = "newVersion.apk"; //新版本保存文件名
            UpdateChecker updateChecker = new UpdateChecker(MainActivity.this,handler);
            String checkUrl = "http://www.topscomm.com:5000/app_download/package/topsRmsNew/update.json" + "?t="+System.currentTimeMillis();
            updateChecker.setCheckUrl(checkUrl); //设置版本号查询地址
            updateChecker.setShowAlert(true); //设置是否显示警示框
            updateChecker.setCheckMessage("已是最新");
            updateChecker.checkForUpdates(); //开始检查
        }
    }
}
