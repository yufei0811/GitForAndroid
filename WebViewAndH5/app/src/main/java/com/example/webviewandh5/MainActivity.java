package com.example.webviewandh5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button commit;
    TextView text;
    LinearLayout linearLayout;
    private JavaMethod javaMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.LinearLayout);
        text = findViewById(R.id.text);
        commit = findViewById(R.id.commit);
        javaMethod = new JavaMethod(this);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        webView.addJavascriptInterface(javaMethod, "android");
        linearLayout.addView(webView);
        webView.loadUrl("file:///android_asset/web.html");

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("javascript:callback('我来自安卓')");
                text.setText("点击安卓Button，调用了JS中的callback方法");
            }
        });
    }

    public void setTextShow(String str) {
        text.setText(str);
    }
}
