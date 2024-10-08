package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLandSizeKatha extends AppCompatActivity {

    private Button btn_color_match;
    private EditText inputUnit2;

    final  static String putUnit2 = "২য় একক", putLand2 = "২য় এককে জমির পরিমাণ", putTotalLeaf = "সর্বমোট পাতা";
    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার", putAverageLeafColor = "পাতার রঙের গড় মান";

    int land2 = 0, total_leaf = 0;
    String crop = "", type = "", irrigationTime = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_size_katha);

        btn_color_match = (Button) findViewById(R.id.buttonColorMatch);
        inputUnit2 = (EditText) findViewById(R.id.inputUnit2);

        Intent intent = getIntent();
        crop = intent.getStringExtra("শস্য");
        type = intent.getStringExtra("প্রকার");
        irrigationTime = intent.getStringExtra("জলসেচনের মুহূর্ত");

        btn_color_match.setEnabled(false);

        inputUnit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    btn_color_match.setEnabled(false);
                } else {
                    btn_color_match.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_color_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(irrigationTime.equals("১ম জলসেচন")) openActivityUreaAmount();
                else openActivityLeafColor();
            }
        });
    }


    public void openActivityLeafColor() {
        Intent intent = new Intent(this, ActivityLeafColor.class);
        intent.putExtra(putUnit2, "কাঠা");
        land2 = Integer.parseInt(inputUnit2.getText().toString());
        intent.putExtra(putLand2, land2);
        intent.putExtra("১ম একক", "নাই");
        intent.putExtra("১ম এককে জমির পরিমাণ", 0);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);

        if(land2 != 0)
        {
            int bigha = land2 / 20;
            total_leaf= 10 + bigha*5;;
            intent.putExtra(putTotalLeaf, total_leaf);
            startActivity(intent);
        }
    }

    public void openActivityUreaAmount() {


        Intent intent = new Intent(this, ActivityUreaAmount.class);
        intent.putExtra(putUnit2, "কাঠা");
        land2 = Integer.parseInt(inputUnit2.getText().toString());
        intent.putExtra(putLand2, land2);
        intent.putExtra("১ম একক", "নাই");
        intent.putExtra("১ম এককে জমির পরিমাণ", 0);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        if(land2 != 0)
        {
            int bigha = land2 / 20;
            total_leaf= 10 + bigha*5;
            intent.putExtra(putTotalLeaf, total_leaf);
            intent.putExtra(putAverageLeafColor, 0);
            startActivity(intent);
        }
    }
}
