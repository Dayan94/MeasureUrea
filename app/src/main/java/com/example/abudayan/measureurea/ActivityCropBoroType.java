package com.example.abudayan.measureurea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityCropBoroType extends AppCompatActivity {

    private Button btn_crop_boro_rupa;
    private Button btn_crop_boro_bona;

    final  static String putCropTitle = "শস্য", putTypeTitle = "প্রকার", putIrrigationTime = "জলসেচনের মুহূর্ত";


    String type = "", irrigaionTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_boro_type);

        btn_crop_boro_rupa = (Button) findViewById(R.id.btnTransplantedBoro);
        btn_crop_boro_bona = (Button) findViewById(R.id.btnSeededBoro);

        btn_crop_boro_rupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "রোপা ধান";
                openActivityUnitSelection();
            }
        });
        btn_crop_boro_bona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "বোনা ধান";
                openActivityUnitSelection();
            }
        });
    }
    public void openActivityUnitSelection() {
        Intent intent = new Intent(this, ActivityUnitSelection.class);
        intent.putExtra(putCropTitle, "বোরো ধান");
        intent.putExtra(putTypeTitle, type);
        intent.putExtra(putIrrigationTime, irrigaionTime);
        startActivity(intent);
    }
}
