package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityUnitSelection extends AppCompatActivity {

    private Button btn_unit_bigha;
    private Button btn_unit_katha;
    private Button btn_unit_acre;
    private Button btn_unit_shotangsho;
    private Button btn_unit_bigha_katha;
    private Button btn_unit_acre_shotangsho;

    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার";

    String crop = "", type = "", irrigationTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_selection);

        btn_unit_bigha = (Button) findViewById(R.id.button1);
        btn_unit_katha = (Button) findViewById(R.id.button2);
        btn_unit_acre = (Button) findViewById(R.id.button3);
        btn_unit_shotangsho = (Button) findViewById(R.id.button4);
        btn_unit_bigha_katha = (Button) findViewById(R.id.button5);
        btn_unit_acre_shotangsho = (Button) findViewById(R.id.button6);

        Intent intent = getIntent();
        crop = intent.getStringExtra("শস্য");
        type = intent.getStringExtra("প্রকার");
        irrigationTime = intent.getStringExtra("জলসেচনের মুহূর্ত");

        btn_unit_bigha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeBigha();
            }
        });
        btn_unit_katha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeKatha();
            }
        });
        btn_unit_acre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeAcre();
            }
        });
        btn_unit_shotangsho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeShotangsho();
            }
        });

        btn_unit_bigha_katha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeBighaKatha();
            }
        });

        btn_unit_acre_shotangsho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLandSizeAcreShotansho();
            }
        });
    }

    public void openActivityLandSizeBigha() {
        Intent intent = new Intent(this, ActivityLandSizeBigha.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

    public void openActivityLandSizeKatha() {
        Intent intent = new Intent(this, ActivityLandSizeKatha.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

    public void openActivityLandSizeAcre() {
        Intent intent = new Intent(this, ActivityLandSizeAcre.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

    public void openActivityLandSizeShotangsho() {
        Intent intent = new Intent(this, ActivityLandSizeShotangsho.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

    public void openActivityLandSizeBighaKatha() {
        Intent intent = new Intent(this, ActivityLandSizeBighaKatha.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

    public void openActivityLandSizeAcreShotansho() {
        Intent intent = new Intent(this, ActivityLandSizeAcreShotangsho.class);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }
}
