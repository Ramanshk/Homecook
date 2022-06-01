package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class RecipeDetailsResponse implements Parcelable {
    public int id;
    public String title;
    public String image;
    public String imageType;
    public int servings;
    public int readyInMinutes;
    public String license;
    public String sourceName;
    public String sourceUrl;
    public String spoonacularSourceUrl;
    public int aggregateLikes;
    public double healthScore;
    public double spoonacularScore;
    public double pricePerServing;
    public ArrayList<Object> analyzedInstructions;
    public boolean cheap;
    public String creditsText;
    public ArrayList<Object> cuisines;
    public boolean dairyFree;
    public ArrayList<Object> diets;
    public String gaps;
    public boolean glutenFree;
    public String instructions;
    public boolean ketogenic;
    public boolean lowFodmap;
    public ArrayList<Object> occasions;
    public boolean sustainable;
    public boolean vegan;
    public boolean vegetarian;
    public boolean veryHealthy;
    public boolean veryPopular;
    public boolean whole30;
    public int weightWatcherSmartPoints;
    public ArrayList<String> dishTypes;
    public ArrayList<ExtendedIngredient> extendedIngredients;
    public String summary;
    public WinePairing winePairing;

    public RecipeDetailsResponse(int id,
                                 String title,
                                 String image,
                                 String imageType,
                                 int servings,
                                 int readyInMinutes,
                                 String license,
                                 String sourceName,
                                 String sourceUrl,
                                 String spoonacularSourceUrl,
                                 int aggregateLikes,
                                 double healthScore,
                                 double spoonacularScore,
                                 double pricePerServing,
                                 ArrayList<Object> analyzedInstructions,
                                 boolean cheap,
                                 String creditsText,
                                 ArrayList<Object> cuisines,
                                 boolean dairyFree,
                                 ArrayList<Object> diets,
                                 String gaps,
                                 boolean glutenFree,
                                 String instructions,
                                 boolean ketogenic,
                                 boolean lowFodmap,
                                 ArrayList<Object> occasions,
                                 boolean sustainable,
                                 boolean vegan,
                                 boolean vegetarian,
                                 boolean veryHealthy,
                                 boolean veryPopular,
                                 boolean whole30,
                                 int weightWatcherSmartPoints,
                                 ArrayList<String> dishTypes,
                                 ArrayList<ExtendedIngredient> extendedIngredients,
                                 String summary,
                                 WinePairing winePairing) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.license = license;
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        this.aggregateLikes = aggregateLikes;
        this.healthScore = healthScore;
        this.spoonacularScore = spoonacularScore;
        this.pricePerServing = pricePerServing;
        this.analyzedInstructions = analyzedInstructions;
        this.cheap = cheap;
        this.creditsText = creditsText;
        this.cuisines = cuisines;
        this.dairyFree = dairyFree;
        this.diets = diets;
        this.gaps = gaps;
        this.glutenFree = glutenFree;
        this.instructions = instructions;
        this.ketogenic = ketogenic;
        this.lowFodmap = lowFodmap;
        this.occasions = occasions;
        this.sustainable = sustainable;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.veryHealthy = veryHealthy;
        this.veryPopular = veryPopular;
        this.whole30 = whole30;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.dishTypes = dishTypes;
        this.extendedIngredients = extendedIngredients;
        this.summary = summary;
        this.winePairing = winePairing;
    }

    protected RecipeDetailsResponse(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        imageType = in.readString();
        servings = in.readInt();
        readyInMinutes = in.readInt();
        license = in.readString();
        sourceName = in.readString();
        sourceUrl = in.readString();
        spoonacularSourceUrl = in.readString();
        aggregateLikes = in.readInt();
        healthScore = in.readDouble();
        spoonacularScore = in.readDouble();
        pricePerServing = in.readDouble();
        cheap = in.readByte() != 0;
        creditsText = in.readString();
        dairyFree = in.readByte() != 0;
        gaps = in.readString();
        glutenFree = in.readByte() != 0;
        instructions = in.readString();
        ketogenic = in.readByte() != 0;
        lowFodmap = in.readByte() != 0;
        sustainable = in.readByte() != 0;
        vegan = in.readByte() != 0;
        vegetarian = in.readByte() != 0;
        veryHealthy = in.readByte() != 0;
        veryPopular = in.readByte() != 0;
        whole30 = in.readByte() != 0;
        weightWatcherSmartPoints = in.readInt();
        dishTypes = in.createStringArrayList();
        extendedIngredients = in.createTypedArrayList(ExtendedIngredient.CREATOR);
        summary = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(imageType);
        dest.writeInt(servings);
        dest.writeInt(readyInMinutes);
        dest.writeString(license);
        dest.writeString(sourceName);
        dest.writeString(sourceUrl);
        dest.writeString(spoonacularSourceUrl);
        dest.writeInt(aggregateLikes);
        dest.writeDouble(healthScore);
        dest.writeDouble(spoonacularScore);
        dest.writeDouble(pricePerServing);
        dest.writeByte((byte) (cheap ? 1 : 0));
        dest.writeString(creditsText);
        dest.writeByte((byte) (dairyFree ? 1 : 0));
        dest.writeString(gaps);
        dest.writeByte((byte) (glutenFree ? 1 : 0));
        dest.writeString(instructions);
        dest.writeByte((byte) (ketogenic ? 1 : 0));
        dest.writeByte((byte) (lowFodmap ? 1 : 0));
        dest.writeByte((byte) (sustainable ? 1 : 0));
        dest.writeByte((byte) (vegan ? 1 : 0));
        dest.writeByte((byte) (vegetarian ? 1 : 0));
        dest.writeByte((byte) (veryHealthy ? 1 : 0));
        dest.writeByte((byte) (veryPopular ? 1 : 0));
        dest.writeByte((byte) (whole30 ? 1 : 0));
        dest.writeInt(weightWatcherSmartPoints);
        dest.writeStringList(dishTypes);
        dest.writeTypedList(extendedIngredients);
        dest.writeString(summary);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecipeDetailsResponse> CREATOR = new Creator<RecipeDetailsResponse>() {
        @Override
        public RecipeDetailsResponse createFromParcel(Parcel in) {
            return new RecipeDetailsResponse(in);
        }

        @Override
        public RecipeDetailsResponse[] newArray(int size) {
            return new RecipeDetailsResponse[size];
        }
    };

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public String getImageType() {
        return imageType;
    }
    public int getServings() {
        return servings;
    }
    public int getReadyInMinutes() {
        return readyInMinutes;
    }
    public String getLicense() {
        return license;
    }
    public String getSourceName() {
        return sourceName;
    }
    public String getSourceUrl() {
        return sourceUrl;
    }
    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }
    public int getAggregateLikes() {
        return aggregateLikes;
    }
    public double getHealthScore() {
        return healthScore;
    }
    public double getSpoonacularScore() {
        return spoonacularScore;
    }
    public double getPricePerServing() {
        return pricePerServing;
    }
    public ArrayList<Object> getAnalyzedInstructions() {
        return analyzedInstructions;
    }
    public boolean isCheap() {
        return cheap;
    }
    public String getCreditsText() {
        return creditsText;
    }
    public ArrayList<Object> getCuisines() {
        return cuisines;
    }
    public boolean isDairyFree() {
        return dairyFree;
    }
    public ArrayList<Object> getDiets() {
        return diets;
    }
    public String getGaps() {
        return gaps;
    }
    public boolean isGlutenFree() {
        return glutenFree;
    }
    public String getInstructions() {
        return instructions;
    }
    public boolean isKetogenic() {
        return ketogenic;
    }
    public boolean isLowFodmap() {
        return lowFodmap;
    }
    public ArrayList<Object> getOccasions() {
        return occasions;
    }
    public boolean isSustainable() {
        return sustainable;
    }
    public boolean isVegan() {
        return vegan;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public boolean isVeryHealthy() {
        return veryHealthy;
    }
    public boolean isVeryPopular() {
        return veryPopular;
    }
    public boolean isWhole30() {
        return whole30;
    }
    public int getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }
    public ArrayList<String> getDishTypes() {
        return dishTypes;
    }
    public ArrayList<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }
    public String getSummary() {
        return summary;
    }
    public WinePairing getWinePairing() {
        return winePairing;
    }
}
