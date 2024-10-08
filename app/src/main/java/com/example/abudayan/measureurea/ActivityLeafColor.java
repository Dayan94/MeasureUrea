package com.example.abudayan.measureurea;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ActivityLeafColor extends AppCompatActivity {

    final  static String putUnit1 = "১ম একক", putUnit2 = "২য় একক", putLand1 = "১ম এককে জমির পরিমাণ", putLand2 = "২য় এককে জমির পরিমাণ";
    final  static String putCropTitle = "শস্য", putIrrigationTime = "জলসেচনের মুহূর্ত",putTypeTitle = "প্রকার", putTotalLeaf = "সর্বমোট পাতা", putAverageLeafColor = "পাতার রঙের গড় মান";

    int total_leaf = 0, unmatched_leaf = 0;
    float avg_leaf_color = 0;
    int land1 = 0, land2 = 0;
    String unit1 = "", unit2 = "", crop = "", type = "", irrigationTime = "";

    int imageNo[] = {R.drawable.leafcolor1, R.drawable.leafcolor2, R.drawable.leafcolor3, R.drawable.leafcolor4, R.drawable.leafcolor5, R.drawable.leafcolor6};
    int countImage = imageNo.length;
    int currentImage = 0;

    private TextSwitcher txtSwitcherHeadline;
    private ImageSwitcher leafColor;
    private ImageButton right;
    private ImageButton left;
    private Button btnToKnowUrea;
    private TextView txtInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_color);

        Intent intent = getIntent();
        crop = intent.getStringExtra(putCropTitle);
        type = intent.getStringExtra(putTypeTitle);
        irrigationTime = intent.getStringExtra(putIrrigationTime);
        unit1 = intent.getStringExtra(putUnit1);
        unit2 = intent.getStringExtra(putUnit2);
        land1 = intent.getIntExtra(putLand1, 0);
        land2 = intent.getIntExtra(putLand2, 0);
        total_leaf= intent.getIntExtra(putTotalLeaf, 0);
        unmatched_leaf = total_leaf;

//        simply add imageswitcher and button to fetch id
        txtSwitcherHeadline = (TextSwitcher) findViewById(R.id.txtSwitcherHeadline);
        txtInstruction = (TextView) findViewById(R.id.txtInstruction);
        leafColor = (ImageSwitcher) findViewById(R.id.leafColor);
        btnToKnowUrea = (Button) findViewById(R.id.btnToKnowUrea);
        right = (ImageButton) findViewById(R.id.right);
        left = (ImageButton) findViewById(R.id.left);



        btnToKnowUrea.setVisibility(View.INVISIBLE);

        leafColor.setFactory(new ViewSwitcher.ViewFactory(){
            @TargetApi(16)
            public View makeView(){
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setBackgroundColor(Color.TRANSPARENT);
                return  imageView;
            }
        });

        leafColor.setImageResource(imageNo[currentImage]);

        right.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
//                now set the code to change images as per rule
                currentImage++;
                if(currentImage == countImage) currentImage = 0;
//                show the image in imageswitcher
                leafColor.setImageResource(imageNo[currentImage]);
            }

        });



        left.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
//                now set the code to change images as per rule
                currentImage--;
                if(currentImage == -1) currentImage = 5;
//                show the image in imageswitcher
                leafColor.setImageResource(imageNo[currentImage]);

            }

        });

        leafColor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                unmatched_leaf--;
                avg_leaf_color = avg_leaf_color + currentImage + 1;
                txtSwitcherHeadline.setText(String.valueOf(unmatched_leaf) + " টি পাতার রঙ মিলানঃ");
                if(unmatched_leaf == 0){
                    avg_leaf_color = avg_leaf_color / total_leaf;
                    txtSwitcherHeadline.setText("নিচে প্রদক্ত বাটনে চাপুন");
                    leafColor.setVisibility((View.INVISIBLE));
                    left.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    btnToKnowUrea.setVisibility(View.VISIBLE);
                    txtInstruction.setText("পাতার রঙ মেলানো সম্পন্ন হয়েছে। নিচে প্রদক্ত বাটন চেপে ইউরিয়া সারের পরিমাণ জানুন");
                }
            }
        });

        txtSwitcherHeadline.setFactory(new ViewSwitcher.ViewFactory() {
            @TargetApi(17)
            public  View makeView(){
                TextView t = new TextView(ActivityLeafColor.this);
                t.setTextColor(Color.BLACK);
                t.setTextSize(30);
                t.setGravity(Gravity.CENTER);
                t.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                return  t;
            }
        });

        btnToKnowUrea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityUreaAmount();
            }
        });

        txtSwitcherHeadline.setText(String.valueOf(unmatched_leaf) + " টি পাতার রঙ মিলানঃ");

    }

    public void openActivityUreaAmount() {
        Intent intent = new Intent(this, ActivityUreaAmount.class);
        intent.putExtra(putUnit1, unit1);
        intent.putExtra(putUnit2, unit2);
        intent.putExtra(putLand1, land1);
        intent.putExtra(putLand2, land2);
        intent.putExtra(putCropTitle, crop);
        intent.putExtra(putIrrigationTime, irrigationTime);
        intent.putExtra(putTypeTitle, type);
        intent.putExtra(putAverageLeafColor, avg_leaf_color);
        startActivity(intent);
    }
}
