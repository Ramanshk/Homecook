package com.example.ProductionProject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProductionProject.Models.ExtendedIngredient;
import com.squareup.picasso.Picasso;

import java.util.List;

import ProductionProject.R;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    Context context;
    List<ExtendedIngredient> ingredientList;

    public IngredientsAdapter(Context context, List<ExtendedIngredient> ingredientList) {
        this.context = context;
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ingredients_card, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        holder.ingredientName.setText(ingredientList.get(position).name);
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/" + ingredientList.get(position).image).into(holder.ingredientImage);
        holder.ingredientImage.setClipToOutline(true);
        holder.ingredientQuantity.setText(String.valueOf(ingredientList.get(position).amount) + " " + ingredientList.get(position).unit);
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    static class IngredientsViewHolder extends RecyclerView.ViewHolder{

        ImageView ingredientImage;
        TextView ingredientName, ingredientQuantity;

        public IngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientImage = itemView.findViewById(R.id.ingredientImage);
            ingredientName = itemView.findViewById(R.id.ingredientName);
            ingredientQuantity = itemView.findViewById(R.id.ingredientQuantity);
        }
    }
}
