package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class ExtendedIngredient implements Parcelable {
    public String aisle;
    public double amount;
    public String consitency;
    public int id;
    public String image;
    public Measures measures;
    public ArrayList<String> meta;
    public String name;
    public String original;
    public String originalName;
    public String unit;

    public ExtendedIngredient(String aisle, double amount, String consitency, int id, String image, Measures measures, ArrayList<String> meta, String name, String original, String originalName, String unit) {
        this.aisle = aisle;
        this.amount = amount;
        this.consitency = consitency;
        this.id = id;
        this.image = image;
        this.measures = measures;
        this.meta = meta;
        this.name = name;
        this.original = original;
        this.originalName = originalName;
        this.unit = unit;
    }

    protected ExtendedIngredient(Parcel in) {
        aisle = in.readString();
        amount = in.readDouble();
        consitency = in.readString();
        id = in.readInt();
        image = in.readString();
        meta = in.createStringArrayList();
        name = in.readString();
        original = in.readString();
        originalName = in.readString();
        unit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(aisle);
        dest.writeDouble(amount);
        dest.writeString(consitency);
        dest.writeInt(id);
        dest.writeString(image);
        dest.writeStringList(meta);
        dest.writeString(name);
        dest.writeString(original);
        dest.writeString(originalName);
        dest.writeString(unit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ExtendedIngredient> CREATOR = new Creator<ExtendedIngredient>() {
        @Override
        public ExtendedIngredient createFromParcel(Parcel in) {
            return new ExtendedIngredient(in);
        }

        @Override
        public ExtendedIngredient[] newArray(int size) {
            return new ExtendedIngredient[size];
        }
    };

    public String getAisle() {
        return aisle;
    }
    public double getAmount() {
        return amount;
    }
    public String getConsitency() {
        return consitency;
    }
    public int getId() {
        return id;
    }
    public String getImage() {
        return image;
    }
    public Measures getMeasures() {
        return measures;
    }
    public ArrayList<String> getMeta() {
        return meta;
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
    public String getUnit() {
        return unit;
    }
}
