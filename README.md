# VersionUpdate
版本更新工具类
1、使用前配置：
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

Step 2. Add the dependency:

    dependencies {
            compile 'com.github.lxj-helloworld:VersionUpdate:1.0.8'
    }

2、分配权限：

  
    <!-- 常规权限 -->
    <uses-permission android:name="android.permission.ACCESS_SUPERUSER"/>
    <!-- 网络访问 -->
    <uses-permission android:name="android.permission.INTERNET"/>
    <!-- 访问GSM网络信息 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <!-- 获取当前WiFi接入状态以及WLAN热点信息 -->
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.CHANGE_WIFI_MULTICAST_STATE"/>
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
    <!-- SD卡写权限 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <!-- SD卡读权限 -->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>



3、调用：

    private TextView check_result_Tv;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == AppVersion.CONNECTFAILED){
                check_result_Tv.setText("连接失败");
            }else if(msg.what == AppVersion.CONNECTSUCCESS){
                check_result_Tv.setText("连接成功");
            }else if(msg.what == AppVersion.NEW_VERSION){
                check_result_Tv.setText("发现新版本 : " + msg.obj.toString());
            }else if(msg.what == AppVersion.ALREADY_NEW){
                check_result_Tv.setText("已是最新版本");
            }else {
                check_result_Tv.setText("unknown");
            }
        }
    };
    

            //新版本保存文件名
            UpdateChecker.apkFileName = "newVersion.apk";
            UpdateChecker updateChecker = new UpdateChecker(UpdateVersionActivity.this,handler);
            String checkUrl = "http://www.topscomm.com:5000/app_download/package/chpcyDebug/update.json" + "?t="+System.currentTimeMillis();
            updateChecker.setCheckUrl(checkUrl); //设置版本号查询地址
            updateChecker.setShowAlert(true); //设置是否显示警示框
            updateChecker.setCheckMessage("已是最新");
            updateChecker.checkForUpdates(); //开始检查 











