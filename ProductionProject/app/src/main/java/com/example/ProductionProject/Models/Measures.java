package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Measures implements Parcelable {
    public Metric metric;
    public Us us;

    public Measures(Metric metric, Us us) {
        this.metric = metric;
        this.us = us;
    }

    protected Measures(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Measures> CREATOR = new Creator<Measures>() {
        @Override
        public Measures createFromParcel(Parcel in) {
            return new Measures(in);
        }

        @Override
        public Measures[] newArray(int size) {
            return new Measures[size];
        }
    };

    public Metric getMetric() {
        return metric;
    }
    public Us getUs() {
        return us;
    }
}
