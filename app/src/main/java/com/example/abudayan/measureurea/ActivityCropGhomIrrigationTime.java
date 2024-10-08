package com.example.abudayan.measureurea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityCropGhomIrrigationTime extends AppCompatActivity {

    private Button btn_crop_ghom_first;
    private Button btn_crop_ghom_second;

    final  static String putIrrigationTime = "জলসেচনের মুহূর্ত";
    String irrigationTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_ghom_irrigation_time);

        btn_crop_ghom_first = (Button) findViewById(R.id.btnFirstIrrigation);
        btn_crop_ghom_second = (Button) findViewById(R.id.btnSecondIrrigation);

        btn_crop_ghom_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irrigationTime = "১ম জলসেচন";
                openActivityCropGhomType();

            }
        });

        btn_crop_ghom_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irrigationTime = "২য় জলসেচন";
                openActivityCropGhomType();

            }
        });
    }

    public void openActivityCropGhomType() {
        Intent intent = new Intent(this, ActivityCropGhomType.class);
        intent.putExtra(putIrrigationTime, irrigationTime);
        startActivity(intent);
    }
}
