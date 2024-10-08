package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCrop extends AppCompatActivity {

    private Button btn_crop_aman;
    private Button btn_crop_boro;
    private Button btn_crop_ghom;
    private Button btn_crop_vutta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        btn_crop_aman = (Button) findViewById(R.id.btnCropAman);
        btn_crop_boro = (Button) findViewById(R.id.btnCropBoro);
        btn_crop_ghom = (Button) findViewById(R.id.btnCropWheat);
        btn_crop_vutta = (Button) findViewById(R.id.btnCropMaize);



        btn_crop_aman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ActivityCrop.this, ActivityUreaAmount.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("crop", putCropTitle2);
//                intent.putExtras(bundle);
//                startActivityForResult(intent,1);
                openActivityCropAmanType();
            }
        });
        btn_crop_boro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCropBoroType();
            }
        });
        btn_crop_ghom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCropGhomIrrigationTime();
            }
        });
        btn_crop_vutta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityUnitSelection();
            }
        });

    }

    public void openActivityCropAmanType() {
        Intent intent = new Intent(this, ActivityCropAmanType.class);
        startActivity(intent);
    }
    public void openActivityCropBoroType() {
        Intent intent = new Intent(this, ActivityCropBoroType.class);
        startActivity(intent);
    }
    public void openActivityCropGhomIrrigationTime() {
        Intent intent = new Intent(this, ActivityCropGhomIrrigationTime.class);
        startActivity(intent);
    }
    public void openActivityUnitSelection() {
        Intent intent = new Intent(this, ActivityUnitSelection.class);
        intent.putExtra("শস্য", "ভুট্টা");
        intent.putExtra("জলসেচনের মুহূর্ত", "নাই");
        intent.putExtra("প্রকার", "নাই");
        startActivity(intent);
    }
}
