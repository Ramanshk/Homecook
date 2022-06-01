package com.example.ProductionProject;

import com.example.ProductionProject.Models.RecipeDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipeDetailsInterface {
    @GET("recipes/{id}/information")
    Call<RecipeDetailsResponse> callRecipeDetails(
            @Path("id") int id,
            @Query("includeNutrition") String includeNutrition,
            @Query("apiKey") String apiKey
    );
}
