package com.example.ProductionProject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProductionProject.Models.RecipeListResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import ProductionProject.R;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    List<RecipeListResponse> list;
    OnRecipeClickListener onRecipeClickListener;

    public RecipeAdapter(List<RecipeListResponse> list, OnRecipeClickListener onRecipeClickListener) {
        this.list = list;
        this.onRecipeClickListener = onRecipeClickListener;
    }

    interface OnRecipeClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipeViewHolder(view, onRecipeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.recipe_title.setText(list.get(position).getTitle());
        holder.recipe_title.setSelected(true);
        Picasso.get().load(list.get(position).getImage()).into(holder.recipe_image);
        holder.recipe_image.setClipToOutline(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //-----------------------------class-----------------------------
    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView recipe_card;
        TextView recipe_title;
        ImageView recipe_image;
        OnRecipeClickListener onRecipeClickListener;

        public RecipeViewHolder(@NonNull View itemView, OnRecipeClickListener onRecipeClickListener) {
            super(itemView);
            recipe_card = itemView.findViewById(R.id.recipe_card);
            recipe_title = itemView.findViewById(R.id.recipe_title);
            recipe_image = itemView.findViewById(R.id.recipe_image);
            this.onRecipeClickListener = onRecipeClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecipeClickListener.onItemClick(getAdapterPosition());
        }
    }
}