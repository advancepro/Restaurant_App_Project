package com.example.restaurant_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.R;
import com.example.restaurant_app.model.FoodTypes;
import com.example.restaurant_app.model.PopularFood;

import java.util.List;

public class FoodTypesAdapter extends RecyclerView.Adapter<FoodTypesAdapter.FoodTypesViewHolder> {

    Context context;
    List<FoodTypes> foodTypesList;

    public FoodTypesAdapter(Context context, List<FoodTypes> FoodTypesList) {
        this.context = context;
        this.foodTypesList = FoodTypesList;
    }

    @NonNull
    @Override
    public FoodTypesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_types_row_item, parent, false);
        return new FoodTypesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodTypesViewHolder holder, int position) {

        holder.foodImage.setImageResource(foodTypesList.get(position).getImageUrl());
        holder.name.setText(foodTypesList.get(position).getName());
        holder.price.setText(foodTypesList.get(position).getPrice());
        holder.rating.setText(foodTypesList.get(position).getRating());
        holder.restorantName.setText(foodTypesList.get(position).getRestorantname());

    }

    @Override
    public int getItemCount() {
        return foodTypesList.size();
    }

    public static final class FoodTypesViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView price, name, rating, restorantName;

        public FoodTypesViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            restorantName = itemView.findViewById(R.id.restorant_name);

        }
    }
}
