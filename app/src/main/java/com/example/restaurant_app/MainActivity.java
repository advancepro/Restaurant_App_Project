package com.example.restaurant_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.restaurant_app.adapter.FoodTypesAdapter;
import com.example.restaurant_app.adapter.PopularFoodAdapter;
import com.example.restaurant_app.model.FoodTypes;
import com.example.restaurant_app.model.PopularFood;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView popularRecycler, foodRecycler;
    PopularFoodAdapter popularFoodAdapter;
    FoodTypesAdapter foodTypesAdapter;

    private Button button_passing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_passing = (Button) findViewById(R.id.button_passing);
        button_passing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailsActivity();
            }
        });

        List<PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new PopularFood("Salmon Balls", "$7.0", R.drawable.food1));
        popularFoodList.add(new PopularFood("Bowly Healthy Food", "$8.5", R.drawable.food2));
        popularFoodList.add(new PopularFood("Italian Macaroni", "$6.8", R.drawable.food3));
        popularFoodList.add(new PopularFood("Spaghetti Bolognese", "$9.8", R.drawable.food4));
        popularFoodList.add(new PopularFood("Chicken Dish In Plate", "$10.8", R.drawable.food5));
        popularFoodList.add(new PopularFood("Bite Squad", "$15.8", R.drawable.food6));

        setPopularRecycler(popularFoodList);

        List<FoodTypes> foodTypesList = new ArrayList<>();

        foodTypesList.add(new FoodTypes(" Poke Bowl Lachs Teriyaki", "$15.5", R.drawable.asiafood1, "4.5", "Happy Restaurant"));
        foodTypesList.add(new FoodTypes(" Khantoke Dinner", "$20.0", R.drawable.asiafood2, "5.0", "Chaki Restaurant"));
        foodTypesList.add(new FoodTypes(" Fried rice Asia food", "$25.0", R.drawable.asiafood3, "8.5", "Asia Restaurant"));
        foodTypesList.add(new FoodTypes(" Chinese food, Sizzling rice", "$30.0", R.drawable.asiafood4, "7.2", "Friends Restaurant"));

        setFoodRecycler(foodTypesList);
    }

    private void setPopularRecycler(List<PopularFood> popularFoodList){
        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);
    }

    private void setFoodRecycler(List<FoodTypes> foodTypesList){
        foodRecycler = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        foodRecycler.setLayoutManager(layoutManager);
        foodTypesAdapter = new FoodTypesAdapter(this, foodTypesList);
        foodRecycler.setAdapter(foodTypesAdapter);
    }

    public void openDetailsActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }
}