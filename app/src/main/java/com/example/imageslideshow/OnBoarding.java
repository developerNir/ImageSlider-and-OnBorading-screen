package com.example.imageslideshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class OnBoarding extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dotsText;

    Button buttonGetStart, skipButton, nextBtn;

    SliderAdapter sliderAdapter;
    int currentPosition;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_boarding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        viewPager = findViewById(R.id.viewPager2);
        dotsLayout = findViewById(R.id.linear_layout);
        buttonGetStart = findViewById(R.id.nextButton);
        skipButton = findViewById(R.id.skipButton);
        nextBtn = findViewById(R.id.nextBtn);


        sliderAdapter = new SliderAdapter(OnBoarding.this);
        viewPager.setAdapter(sliderAdapter);

        // create dots ---------------------------------
        createDots(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        skipButton.setOnClickListener(view -> {
            startActivity(new Intent(OnBoarding.this, MainActivity.class));
            finish();
        });

        buttonGetStart.setOnClickListener(view -> {
            startActivity(new Intent(OnBoarding.this, MainActivity.class));
            finish();
        });

        nextBtn.setOnClickListener(view -> {
            viewPager.setCurrentItem(currentPosition+1);
        });



    }// end OnCreate -------------------------------------

    private void createDots(int position){

        dotsText = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0 ; i<dotsText.length; i++){

            dotsText[i] = new TextView(this);
            dotsText[i].setText(Html.fromHtml("&#8226;"));
            dotsText[i].setTextSize(35);

            dotsLayout.addView(dotsText[i]);
        }
        if (dotsText.length > 0){
            dotsText[position].setTextColor(getColor(R.color.Blue));
        }


    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }


        @Override
        public void onPageSelected(int position) {

            createDots(position);
            currentPosition = position;

            if (position == 0){
                buttonGetStart.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                buttonGetStart.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                buttonGetStart.setVisibility(View.INVISIBLE);
            } else if (position == 3) {
                    buttonGetStart.setVisibility(View.VISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}