package com.example.restaurant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private Button add_to_chart;

    TextView result;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        result = (TextView) findViewById(R.id.result);

        add_to_chart = (Button) findViewById(R.id.add_to_chart);

        add_to_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSavedPlace();
            }
        });
    }

    public void openSavedPlace() {
        Toast.makeText(DetailsActivity.this, "Added to the chart successfully ", Toast.LENGTH_SHORT).show();
    }

    public void increaseResult(View view){
        counter++;
        result.setText(Integer.toString(counter));
    }

    public void decreaseResult(View v){
        counter--;
        result.setText(Integer.toString(counter));

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
}