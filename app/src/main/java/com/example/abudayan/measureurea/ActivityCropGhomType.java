package com.example.abudayan.measureurea;

import android.content.Intent;
import android.content.pm.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCropGhomType extends AppCompatActivity {

    private Button btn_crop_ghom_timely_seed;
    private Button btn_crop_ghom_second;

    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার";

    String type = "", irrigaionTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_ghom_type);

        btn_crop_ghom_timely_seed = (Button) findViewById(R.id.btnTimelySeeded);
        btn_crop_ghom_second = (Button) findViewById(R.id.btnLatelySeeded);

        Intent intent = getIntent();
        irrigaionTime = intent.getStringExtra(ActivityCropGhomIrrigationTime.putIrrigationTime);

        btn_crop_ghom_timely_seed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "সময়মত বোনা বীজ";
                openActivityUnitSelection();
            }
        });

        btn_crop_ghom_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "দেরিতে বোনা বীজ";
                openActivityUnitSelection();
            }
        });


    }
    public void openActivityUnitSelection() {
        Intent intent = new Intent(this, ActivityUnitSelection.class);
        intent.putExtra(putCropTitle, "গম");
        intent.putExtra(putIrrigationTime, irrigaionTime);
        intent.putExtra(putTypeTitle, type);
        startActivity(intent);
    }

}
