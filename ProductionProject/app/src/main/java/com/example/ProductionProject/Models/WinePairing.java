package com.example.ProductionProject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class WinePairing implements Parcelable {
    public ArrayList<String> pairedWines;
    public String pairingText;
    public ArrayList<ProductMatch> productMatches;

    public WinePairing(ArrayList<String> pairedWines, String pairingText, ArrayList<ProductMatch> productMatches) {
        this.pairedWines = pairedWines;
        this.pairingText = pairingText;
        this.productMatches = productMatches;
    }

    protected WinePairing(Parcel in) {
        pairedWines = in.createStringArrayList();
        pairingText = in.readString();
        productMatches = in.createTypedArrayList(ProductMatch.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(pairedWines);
        dest.writeString(pairingText);
        dest.writeTypedList(productMatches);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WinePairing> CREATOR = new Creator<WinePairing>() {
        @Override
        public WinePairing createFromParcel(Parcel in) {
            return new WinePairing(in);
        }

        @Override
        public WinePairing[] newArray(int size) {
            return new WinePairing[size];
        }
    };

    public ArrayList<String> getPairedWines() {
        return pairedWines;
    }

    public void setPairedWines(ArrayList<String> pairedWines) {
        this.pairedWines = pairedWines;
    }

    public String getPairingText() {
        return pairingText;
    }

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    public ArrayList<ProductMatch> getProductMatches() {
        return productMatches;
    }

    public void setProductMatches(ArrayList<ProductMatch> productMatches) {
        this.productMatches = productMatches;
    }
}
