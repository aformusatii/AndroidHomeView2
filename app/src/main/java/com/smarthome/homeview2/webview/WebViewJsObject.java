package com.smarthome.homeview2.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class WebViewJsObject {

    private Context context;

    private WebView webView;

    public WebViewJsObject(Context context, WebView webView) {
        this.context = context;
        this.webView =webView;
    }

    @JavascriptInterface
    public void clearCache() {
        webView.clearCache(true);
    }

}
