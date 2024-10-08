package com.example.abudayan.measureurea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLandSizeAcreShotangsho extends AppCompatActivity {

    private Button btn_color_match;
    private EditText inputUnit1;
    private EditText inputUnit2;

    final  static String putUnit1 = "১ম একক", putUnit2 = "২য় একক", putLand1 = "১ম এককে জমির পরিমাণ", putLand2 = "২য় এককে জমির পরিমাণ";
    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার", putTotalLeaf = "সর্বমোট পাতা", putAverageLeafColor = "পাতার রঙের গড় মান";

    int land1 = 0, land2 = 0, total_leaf = 0;
    String crop = "", type = "", irrigationTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_size_acre_shotangsho);

        btn_color_match = (Button) findViewById(R.id.buttonColorMatch);
        inputUnit1 = (EditText) findViewById(R.id.inputUnit1);
        inputUnit2 = (EditText) findViewById(R.id.inputUnit2);

        Intent intent = getIntent();
        crop = intent.getStringExtra("শস্য");
        type = intent.getStringExtra("প্রকার");
        irrigationTime = intent.getStringExtra("জলসেচনের মুহূর্ত");

        btn_color_match.setEnabled(false);
        inputUnit1.addTextChangedListener(textWatcher);
        inputUnit2.addTextChangedListener(textWatcher);

        btn_color_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(irrigationTime.equals("১ম জলসেচন")) openActivityUreaAmount();
                else openActivityLeafColor();
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String land1 = inputUnit1.getText().toString().trim();
            String land2 = inputUnit2.getText().toString().trim();
            btn_color_match.setEnabled(!land1.isEmpty() && !land2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    public void openActivityLeafColor() {
        Intent intent = new Intent(this, ActivityLeafColor.class);
        intent.putExtra(putUnit1, "একর");
        intent.putExtra(putUnit2, "শতাংশ");
        land1 = Integer.parseInt(inputUnit1.getText().toString());
        land2 = Integer.parseInt(inputUnit2.getText().toString());
        intent.putExtra(putLand1, land1);
        intent.putExtra(putLand2, land2);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        if(land1 != 0 && land2 != 0)
        {
            total_leaf=10+(land1-1)*5;;
            intent.putExtra(putTotalLeaf, total_leaf);
            startActivity(intent);
        }
    }

    public void openActivityUreaAmount() {


        Intent intent = new Intent(this, ActivityUreaAmount.class);
        intent.putExtra(putUnit1, "একর");
        intent.putExtra(putUnit2, "শতাংশ");
        land1 = Integer.parseInt(inputUnit1.getText().toString());
        land2 = Integer.parseInt(inputUnit2.getText().toString());
        intent.putExtra(putLand1, land1);
        intent.putExtra(putLand2, land2);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        if(land1 != 0)
        {
            total_leaf=10+(land1-1)*5;;
            intent.putExtra(putTotalLeaf, total_leaf);
            intent.putExtra(putAverageLeafColor, 0);
            startActivity(intent);
        }
    }
}
