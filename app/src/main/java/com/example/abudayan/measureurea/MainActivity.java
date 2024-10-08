package com.example.abudayan.measureurea;


import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_crop;
    private Button btn_info;
    private Button btn_advantage;
    private Button btn_reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_crop = (Button) findViewById(R.id.button1);
        btn_info = (Button) findViewById(R.id.button2);
        btn_advantage = (Button) findViewById(R.id.button3);
        btn_reference = (Button) findViewById(R.id.button4);

        btn_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCrop();
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfo();
            }
        });

        btn_advantage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAdvantage();
            }
        });

        btn_reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityReference();
            }
        });
    }

    public void openActivityCrop() {
        Intent intent = new Intent(this, ActivityCrop.class);
        startActivity(intent);
    }

    public void openActivityInfo() {
        Intent intent = new Intent(this, ActivityInfo.class);
        startActivity(intent);
    }

    public void openActivityAdvantage() {
        Intent intent = new Intent(this, ActivityAdvantage.class);
        startActivity(intent);
    }

    public void openActivityReference() {
        Intent intent = new Intent(this, ActivityReference.class);
        startActivity(intent);
    }
}
