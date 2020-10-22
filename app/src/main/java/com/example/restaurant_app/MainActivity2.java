package com.example.restaurant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private Button asparagus_recipe_btn;
    private Button potato_salad_btn;
    private Button greek_salad_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        asparagus_recipe_btn = (Button) findViewById(R.id.asparagus_recipe_btn);
        potato_salad_btn = (Button) findViewById(R.id.potato_salad_btn);
        greek_salad_btn = (Button) findViewById(R.id.greek_salad_btn);



        asparagus_recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails();
            }
        });

        potato_salad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail();
            }
        });

        greek_salad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetai();
            }
        });

    }

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    public void openDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);

    }
    public void openDetail() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);

    }
    public void openDetai() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);

    }
}