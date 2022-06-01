package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Us implements Parcelable {
    public double amount;
    public String unitLong;
    public String unitShort;

    public Us(double amount, String unitLong, String unitShort) {
        this.amount = amount;
        this.unitLong = unitLong;
        this.unitShort = unitShort;
    }

    protected Us(Parcel in) {
        amount = in.readDouble();
        unitLong = in.readString();
        unitShort = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(amount);
        dest.writeString(unitLong);
        dest.writeString(unitShort);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Us> CREATOR = new Creator<Us>() {
        @Override
        public Us createFromParcel(Parcel in) {
            return new Us(in);
        }

        @Override
        public Us[] newArray(int size) {
            return new Us[size];
        }
    };

    public double getAmount() {
        return amount;
    }
    public String getUnitLong() {
        return unitLong;
    }
    public String getUnitShort() {
        return unitShort;
    }
}
