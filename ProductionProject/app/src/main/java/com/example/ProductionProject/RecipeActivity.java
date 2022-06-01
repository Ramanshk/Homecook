package com.example.ProductionProject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ProductionProject.Models.RecipeDetailsResponse;
import com.example.ProductionProject.Models.RecipeListResponse;
import com.squareup.picasso.Picasso;

import ProductionProject.R;
import ProductionProject.databinding.ActivityRecipeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity {

    String url = "https://api.spoonacular.com/";
    IngredientsAdapter ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecipeBinding binding = ActivityRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        RecipeListResponse response = intent.getParcelableExtra("recipe");
        int rid = response.getId();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipeDetailsInterface recipeDetailsInterface = retrofit.create(RecipeDetailsInterface.class);

        Call<RecipeDetailsResponse> call = recipeDetailsInterface.callRecipeDetails(rid, "false", getString(R.string.apiKey));

        call.enqueue(new Callback<RecipeDetailsResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<RecipeDetailsResponse> call, Response<RecipeDetailsResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                } else {
                    RecipeDetailsResponse data = response.body();
                    binding.title.setText(data.title);
                    Picasso.get().load(data.image).into(binding.dishImage);
                    binding.dishImage.setClipToOutline(true);
                    binding.servings.setText(String.valueOf(data.servings));
                    binding.readyInMinutes.setText(String.valueOf(data.readyInMinutes));
                    binding.likesCount.setText(String.valueOf(data.aggregateLikes));
                    binding.healthScore.setText(String.valueOf(data.healthScore));
                    binding.ingredientsRecyclerView.setLayoutManager(new LinearLayoutManager(RecipeActivity.this, LinearLayoutManager.VERTICAL, false));
                    ingredientsAdapter = new IngredientsAdapter(RecipeActivity.this, data.extendedIngredients);
                    binding.ingredientsRecyclerView.setAdapter(ingredientsAdapter);
                    binding.summary.setText(Html.fromHtml(data.summary, Html.FROM_HTML_MODE_COMPACT) + "\n\n" + "Link to the detailed recipe by the creator: " + data.sourceUrl);
                }
            }

            @Override
            public void onFailure(Call<RecipeDetailsResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}