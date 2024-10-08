package com.example.abudayan.measureurea;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCropAmanType extends AppCompatActivity {

    private Button btn_crop_aman_rupa;
    private Button btn_crop_aman_bona;

    final  static String putCropTitle = "শস্য", putTypeTitle = "প্রকার", putIrrigationTime = "জলসেচনের মুহূর্ত";
    String type = "", irrigaionTime = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_aman_type);

        btn_crop_aman_rupa = (Button) findViewById(R.id.btnTransplantedAman);
        btn_crop_aman_bona = (Button) findViewById(R.id.btnSeededAman);



        btn_crop_aman_rupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "রোপা ধান";
                openActivityUnitSelection();
            }
        });
        btn_crop_aman_bona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "বোনা ধান";
                openActivityUnitSelection();
            }
        });
    }

    public void openActivityUnitSelection() {

        Intent intent = new Intent(this, ActivityUnitSelection.class);
        intent.putExtra(putCropTitle, "আমন ধান");
        intent.putExtra(putTypeTitle, type);
        intent.putExtra(putIrrigationTime, irrigaionTime);
        startActivity(intent);
    }
}
