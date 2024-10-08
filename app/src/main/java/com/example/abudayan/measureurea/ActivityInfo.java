package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityInfo extends AppCompatActivity {

    private Button btn_info_aman;
    private Button btn_info_boro;
    private Button btn_info_ghom;
    private Button btn_info_vutta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btn_info_aman = (Button) findViewById(R.id.button1);
        btn_info_boro = (Button) findViewById(R.id.button2);
        btn_info_ghom = (Button) findViewById(R.id.button3);
        btn_info_vutta = (Button) findViewById(R.id.button4);

        btn_info_aman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoAman();
            }
        });
        btn_info_boro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoBoro();
            }
        });
        btn_info_ghom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoGhom();
            }
        });
        btn_info_vutta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoVutta();
            }
        });
    }

    public void openActivityInfoAman() {
        Intent intent = new Intent(this, ActivityInfoAman.class);
        startActivity(intent);
    }
    public void openActivityInfoBoro() {
        Intent intent = new Intent(this, ActivityInfoBoro.class);
        startActivity(intent);
    }
    public void openActivityInfoGhom() {
        Intent intent = new Intent(this, ActivityInfoGhom.class);
        startActivity(intent);
    }
    public void openActivityInfoVutta() {
        Intent intent = new Intent(this, ActivityInfoVutta.class);
        startActivity(intent);
    }
}
