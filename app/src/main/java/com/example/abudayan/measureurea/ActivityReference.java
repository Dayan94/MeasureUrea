package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ActivityReference extends AppCompatActivity {

    private Button btn_nitrogenparameters;
    private Button btn_irri;
    private Button btn_brri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);

        btn_nitrogenparameters = (Button) findViewById(R.id.button1);
        btn_irri = (Button) findViewById(R.id.button2);
        btn_brri = (Button) findViewById(R.id.button3);

        btn_nitrogenparameters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityNitrogenparameters();
            }
        });

        btn_irri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityIrri();
            }
        });

        btn_brri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBrri();
            }
        });
    }

    public void openActivityNitrogenparameters() {
        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("http://www.nitrogenparameters.com/using-lcc.html");
    }

    public void openActivityIrri() {

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("http://www.knowledgebank.irri.org/step-by-step-production/growth/soil-fertility/leaf-color-chart");
    }

    public void openActivityBrri() {

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("http://knowledgebank-brri.org/leaf-color-chart-lcc-for-fertilizer-n-management-in-rice/");
    }

}
