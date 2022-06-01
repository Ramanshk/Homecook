package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class UsedIngredient implements Parcelable {
    public int id;
    public double amount;
    public String unit;
    public String unitLong;
    public String unitShort;
    public String aisle;
    public String name;
    public String original;
    public String originalName;
    public ArrayList<String> meta;
    public String image;

    public UsedIngredient(int id,
                          double amount,
                          String unit,
                          String unitLong,
                          String unitShort,
                          String aisle,
                          String name,
                          String original,
                          String originalName,
                          ArrayList<String> meta,
                          String image) {
        this.id = id;
        this.amount = amount;
        this.unit = unit;
        this.unitLong = unitLong;
        this.unitShort = unitShort;
        this.aisle = aisle;
        this.name = name;
        this.original = original;
        this.originalName = originalName;
        this.meta = meta;
        this.image = image;
    }

    protected UsedIngredient(Parcel in) {
        id = in.readInt();
        amount = in.readDouble();
        unit = in.readString();
        unitLong = in.readString();
        unitShort = in.readString();
        aisle = in.readString();
        name = in.readString();
        original = in.readString();
        originalName = in.readString();
        meta = in.createStringArrayList();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(amount);
        dest.writeString(unit);
        dest.writeString(unitLong);
        dest.writeString(unitShort);
        dest.writeString(aisle);
        dest.writeString(name);
        dest.writeString(original);
        dest.writeString(originalName);
        dest.writeStringList(meta);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UsedIngredient> CREATOR = new Creator<UsedIngredient>() {
        @Override
        public UsedIngredient createFromParcel(Parcel in) {
            return new UsedIngredient(in);
        }

        @Override
        public UsedIngredient[] newArray(int size) {
            return new UsedIngredient[size];
        }
    };

    public int getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public String getUnit() {
        return unit;
    }
    public String getUnitLong() {
        return unitLong;
    }
    public String getUnitShort() {
        return unitShort;
    }
    public String getAisle() {
        return aisle;
    }
    public String getName() {
        return name;
    }
    public String getOriginal() {
        return original;
    }
    public String getOriginalName() {
        return originalName;
    }
    public ArrayList<String> getMeta() {
        return meta;
    }
    public String getImage() {
        return image;
    }
}
