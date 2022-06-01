package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class RecipeListResponse implements Parcelable {
    public int id;
    public String title;
    public String image;
    public String imageType;
    public int usedIngredientCount;
    public int missedIngredientCount;
    public ArrayList<MissedIngredient> missedIngredients;
    public ArrayList<UsedIngredient> usedIngredients;
    public ArrayList<Object> unusedIngredients;
    public int likes;

    public RecipeListResponse(int id,
                              String title,
                              String image,
                              String imageType,
                              int usedIngredientCount,
                              int missedIngredientCount,
                              ArrayList<MissedIngredient> missedIngredients,
                              ArrayList<UsedIngredient> usedIngredients,
                              ArrayList<Object> unusedIngredients,
                              int likes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.usedIngredientCount = usedIngredientCount;
        this.missedIngredientCount = missedIngredientCount;
        this.missedIngredients = missedIngredients;
        this.usedIngredients = usedIngredients;
        this.unusedIngredients = unusedIngredients;
        this.likes = likes;
    }

    public RecipeListResponse() {

    }

    protected RecipeListResponse(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        imageType = in.readString();
        usedIngredientCount = in.readInt();
        missedIngredientCount = in.readInt();
        missedIngredients = in.createTypedArrayList(MissedIngredient.CREATOR);
        likes = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(imageType);
        dest.writeInt(usedIngredientCount);
        dest.writeInt(missedIngredientCount);
        dest.writeTypedList(missedIngredients);
        dest.writeInt(likes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecipeListResponse> CREATOR = new Creator<RecipeListResponse>() {
        @Override
        public RecipeListResponse createFromParcel(Parcel in) {
            return new RecipeListResponse(in);
        }

        @Override
        public RecipeListResponse[] newArray(int size) {
            return new RecipeListResponse[size];
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
    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }
    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }
    public ArrayList<MissedIngredient> getMissedIngredients() {
        return missedIngredients;
    }
    public ArrayList<UsedIngredient> getUsedIngredients() {
        return usedIngredients;
    }
    public ArrayList<Object> getUnusedIngredients() {
        return unusedIngredients;
    }
    public int getLikes() {
        return likes;
    }
}
