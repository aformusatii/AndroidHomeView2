package com.smarthome.homeview2.activity;

import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.smarthome.homeview2.R;
import com.smarthome.homeview2.webview.WebViewConfiguration;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        WebViewConfiguration webViewConfig = new WebViewConfiguration(this);
        webViewConfig.setupWebView();
    }

    public void onStart() {
        super.onStart();

        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().acceptCookie();
    }

    @Override
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

}
