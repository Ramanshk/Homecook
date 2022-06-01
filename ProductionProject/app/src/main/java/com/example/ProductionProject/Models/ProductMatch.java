package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ProductMatch implements Parcelable {public int id;
    public String title;
    public String description;
    public String price;
    public String imageUrl;
    public double averageRating;
    public double ratingCount;
    public double score;
    public String link;

    public ProductMatch(int id, String title, String description, String price, String imageUrl, double averageRating, double ratingCount, double score, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.score = score;
        this.link = link;
    }

    protected ProductMatch(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        price = in.readString();
        imageUrl = in.readString();
        averageRating = in.readDouble();
        ratingCount = in.readDouble();
        score = in.readDouble();
        link = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeString(imageUrl);
        dest.writeDouble(averageRating);
        dest.writeDouble(ratingCount);
        dest.writeDouble(score);
        dest.writeString(link);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductMatch> CREATOR = new Creator<ProductMatch>() {
        @Override
        public ProductMatch createFromParcel(Parcel in) {
            return new ProductMatch(in);
        }

        @Override
        public ProductMatch[] newArray(int size) {
            return new ProductMatch[size];
        }
    };

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public double getAverageRating() {
        return averageRating;
    }
    public double getRatingCount() {
        return ratingCount;
    }
    public double getScore() {
        return score;
    }
    public String getLink() {
        return link;
    }
}
