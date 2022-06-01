package com.example.ProductionProject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProductionProject.Models.RecipeListResponse;

import java.util.List;

import ProductionProject.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowRecipesActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener {

    String url = "https://api.spoonacular.com/";
    RecyclerView recyclerView;
    List<RecipeListResponse> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipes);
        recyclerView = findViewById(R.id.recycler_recipe);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipeListInterface api = retrofit.create(RecipeListInterface.class);

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("Ingredient");

        Call<List<RecipeListResponse>> call = api.callRecipes(getString(R.string.apiKey), "100", ingredient);
        call.enqueue(new Callback<List<RecipeListResponse>>() {
            @Override
            public void onResponse(Call<List<RecipeListResponse>> call, Response<List<RecipeListResponse>> response) {
                data = response.body();
                RecipeAdapter recipeAdapter = new RecipeAdapter(data, ShowRecipesActivity.this);
                recyclerView.setLayoutManager(new GridLayoutManager(ShowRecipesActivity.this, 1));
                recyclerView.setAdapter(recipeAdapter);
            }

            @Override
            public void onFailure(Call<List<RecipeListResponse>> call, Throwable t) {
                Toast.makeText(ShowRecipesActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(ShowRecipesActivity.this, RecipeActivity.class);
        intent.putExtra("recipe", data.get(position));
        startActivity(intent);
    }
}