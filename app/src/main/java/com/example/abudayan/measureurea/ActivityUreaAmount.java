package com.example.abudayan.measureurea;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ActivityUreaAmount extends AppCompatActivity {

    final  static String putUnit1 = "১ম একক", putUnit2 = "২য় একক", putLand1 = "১ম এককে জমির পরিমাণ", putLand2 = "২য় এককে জমির পরিমাণ";
    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার", putAverageLeafColor = "পাতার রঙের গড় মান";

    private TextView finalStatement;
    private TextView ureaAmount;
    private Button btnToBackHomePage;

    String crop = "",type = "",irrigationTime = "",unit1 = "", unit2 = "";
    int land1 = 0, land2 = 0;
    float avg_leaf_color = 0;
    long urea = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urea_amount);

        finalStatement = (TextView) findViewById(R.id.finalStatement);
        ureaAmount = (TextView) findViewById(R.id.ureaAmount);
        btnToBackHomePage = (Button) findViewById(R.id.btnToBackHomePage);
        ureaAmount.setBackgroundColor(Color.BLUE);
        Intent intent = getIntent();
        crop = intent.getStringExtra(putCropTitle);
        type = intent.getStringExtra(putTypeTitle);
        irrigationTime = intent.getStringExtra(putIrrigationTime);
        unit1 = intent.getStringExtra(putUnit1);
        unit2 = intent.getStringExtra(putUnit2);
        land1 = intent.getIntExtra(putLand1, 0);
        land2 = intent.getIntExtra(putLand2, 0);
        avg_leaf_color = intent.getFloatExtra(putAverageLeafColor, 0);

        finalStatement.setTextColor(Color.BLACK);
        ureaAmount.setTextColor(Color.BLACK);
        ureaAmount.setShadowLayer(100, 2, 2, Color.BLUE);
        ureaAmount.setBackgroundColor(Color.TRANSPARENT);
//        ureaAmount.setText(crop + " " + type + " " + irrigationTime + " " + land1 + " "  + unit1 + " "  + land2 + " "  +  unit2 + " "   + avg_leaf_color);


        if((type.equals("রোপা ধান") && avg_leaf_color < 3.5) || (type.equals("বোনা ধান") && avg_leaf_color < 3))
        {
            if(crop.equals("আমন ধান")) {
                if(unit1.equals("বিঘা")) urea = land1 * 7500;
                else if(unit1.equals("কাঠা")) urea = land1 * 375;
                else if(unit1.equals("একর")) urea = land1 * 22730;
                else if(unit1.equals("শতাংশ")) urea = land1 * 230;

                if(unit2.equals("কাঠা")) urea = urea + land2 * 375;
                else if(unit2.equals("শতাংশ")) urea = urea + land2 * 230;
            } else {
                if(unit1.equals("বিঘা")) urea = land1 * 9000;
                else if(unit1.equals("কাঠা")) urea = land1 * 450;
                else if(unit1.equals("একর")) urea = land1 * 27270;
                else if(unit1.equals("শতাংশ")) urea = land1 * 270;

                if(unit2.equals("কাঠা")) urea = urea + land2 * 375;
                else if(unit2.equals("শতাংশ")) urea = urea + land2 * 270;
            }
        }
        else if((crop.equals("ভুট্টা") && avg_leaf_color < 5) || (type.equals("দেরিতে বোনা বীজ")  && avg_leaf_color < 4) || (type.equals("সময়মত বোনা বীজ") && avg_leaf_color >= 4))
        {
            if(unit1.equals("বিঘা")) urea = land1 * 8250;
            else if(unit1.equals("কাঠা")) urea = land1 * 410;
            else if(unit1.equals("একর")) urea = land1 * 25000;
            else if(unit1.equals("শতাংশ")) urea = land1 * 250;

            if(unit2.equals("কাঠা")) urea = urea + land2 * 410;
            else if(unit2.equals("শতাংশ")) urea = urea + land2 * 250;
        }
        else if(type.equals("সময়মত বোনা বীজ") && avg_leaf_color < 4)
        {
            if(unit1.equals("বিঘা")) urea = land1 * 13250;
            else if(unit1.equals("কাঠা")) urea = land1 * 660;
            else if(unit1.equals("একর")) urea = land1 * 40000;
            else if(unit1.equals("শতাংশ")) urea = land1 * 400;

            if(unit2.equals("কাঠা")) urea = urea + land2 * 660;
            else if(unit2.equals("শতাংশ")) urea = urea + land2 * 400;
        }
        else if(type.equals("দেরিতে বোনা বীজ") && avg_leaf_color >= 4) {
            if(unit1.equals("বিঘা")) urea = land1 * 5000;
            else if(unit1.equals("কাঠা")) urea = land1 * 250;
            else if (unit1.equals("একর")) urea = land1 * 15000;
            else if(unit1.equals("শতাংশ")) urea = land1 * 150;

            if(unit2.equals("কাঠা")) urea = urea + land2 * 250;
            else if(unit2.equals("শতাংশ")) urea = urea + land2 * 150;
        }

        if(urea == 0)
        {
            if(crop.equals("আমন ধান")) finalStatement.setText("আমন ধানের ক্ষেত্রে ইউরিয়া সার প্রয়োগের প্রয়োজন নেই");
            else if(crop.equals("বোরো ধান")) finalStatement.setText("বোরো ধানের ক্ষেত্রে ইউরিয়া সার প্রয়োগের প্রয়োজন নেই");
            else if(crop.equals("ভুট্টা")) finalStatement.setText("ভুট্টার ক্ষেত্রে ইউরিয়া সার প্রয়োগের প্রয়োজন নেই");
            ureaAmount.setText("৫ দিন পর আবার যাচাই করুন");
        }
        else
        {
            if(crop.equals("আমন ধান")) finalStatement.setText("আমন ধানের ক্ষেত্রে ইউরিয়া সার দিতে হবেঃ");
            if(crop.equals("বোরো ধান")) finalStatement.setText("বোরো ধানের ক্ষেত্রে ইউরিয়া সার দিতে হবেঃ");
            if(crop.equals("গম")) finalStatement.setText("গমের ক্ষেত্রে ইউরিয়া সার দিতে হবেঃ");
            if(crop.equals("ভুট্টা")) finalStatement.setText("ভুট্টার ক্ষেত্রে ইউরিয়া সার দিতে হবেঃ");

            if(urea >= 40000) {
                ureaAmount.append(String.valueOf(urea / 40000) + " মন ");
                urea %= 40000;
            }
            if(urea >= 1000) {
                ureaAmount.append(String.valueOf(urea / 1000) + " কেজি ");
                urea %= 1000;
            }
            if(urea != 0) ureaAmount.append(String.valueOf(urea) + " গ্রাম");

            ureaAmount.append("\n\nজমিতে সার দেবার 10 দিন পর আবার যাচাই করুন");
        }
        btnToBackHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActiviy();
            }
        });
    }

    public void openMainActiviy() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
