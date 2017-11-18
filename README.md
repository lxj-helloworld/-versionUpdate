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
2、分配权限：



<!-- 网络访问 -->
<uses-permission android:name="android.permission.INTERNET"/>
<!-- 访问GSM网络信息 -->
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<!-- 获取当前WiFi接入状态以及WLAN热点信息 -->
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<!-- SD卡写权限 -->
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<!-- SD卡读权限 -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>




3、调用：







