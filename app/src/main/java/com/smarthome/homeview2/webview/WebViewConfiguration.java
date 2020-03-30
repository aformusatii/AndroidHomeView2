package com.smarthome.homeview2.webview;

import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.smarthome.homeview2.R;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewConfiguration {

    private AppCompatActivity activity;

    public WebViewConfiguration(AppCompatActivity activity) {
        this.activity = activity;
    }

    public WebView setupWebView() {
        final WebView wv = (WebView) activity.findViewById(R.id.MainWebView);
        // wv.getSettings().setBuiltInZoomControls(true);
        // wv.setInitialScale(1);
        wv.getSettings().setUseWideViewPort(true);

        wv.clearCache(true);
        //wv.clearHistory();

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        wv.addJavascriptInterface(new WebViewJsObject(activity.getApplicationContext(), wv), "AndroidObj");

        wv.loadUrl("http://htmlsketcher.com/home2/");

        wv.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int vis) {
                wv.loadUrl("javascript:{};");
            }
        });

        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                CookieSyncManager.getInstance().sync();
            }
        });

        return wv;
    }

}
