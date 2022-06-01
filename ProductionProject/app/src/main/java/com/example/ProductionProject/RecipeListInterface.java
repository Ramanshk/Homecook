package com.example.ProductionProject;

import com.example.ProductionProject.Models.RecipeListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeListInterface {
    @GET("recipes/findByIngredients")
    Call<List<RecipeListResponse>> callRecipes(
            @Query("apiKey") String apiKey,
            @Query("number") String number,
            @Query("ingredients") String ingredients
    );
}