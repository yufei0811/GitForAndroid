package com.example.webviewandh5;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;

public class JavaMethod {
    private MainActivity mainActivity;
    private Handler uiHandler;

    public JavaMethod(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        uiHandler = new Handler(Looper.getMainLooper());
    }

    @JavascriptInterface
    public void JsToJavaInterface(final String param) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                mainActivity.setTextShow("点击H5中的Button,调用JsToJavaInterface方法:" + param);
            }
        });
    }
}
