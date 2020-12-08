package com.example.restaurant_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;

public class MainActivity3 extends AppCompatActivity {

    android.widget.Button button;
    Balloon balloon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initBackgroundImage();

        button = findViewById(R.id.button);

        balloon = new Balloon.Builder(getApplicationContext())
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setArrowVisible(true)
                .setWidthRatio(1.0f)
                .setHeight(65)
                .setTextSize(15f)
                .setArrowPosition(0.5f)
                .setCornerRadius(4f)
                .setText("Student of Ala-Too University")
                .setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite))
                .setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                .setBalloonAnimation(com.skydoves.balloon.BalloonAnimation.FADE)
                .build();


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                balloon.showAlignBottom(button);

            }
        });
    }
    protected void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.view);
        Glide.with(this)
                .load(R.drawable.image)
                .into(background);
    }
}