package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class openBrowser extends Activity {
    AutoCompleteTextView auto;
    Button btnSearch, btnBefore;
    WebView web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_myroom_openbrowser);
        String[] items = {"https://op.gg/", "https://m.daum.net", "https://m.naver.com"};

        auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnBefore = (Button) findViewById(R.id.btnBefore);
        web = (WebView) findViewById(R.id.webView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        web.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(auto.getText().toString());
                Toast.makeText(getApplicationContext(),"이동합니다", Toast.LENGTH_SHORT).show();
            }
        });

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
