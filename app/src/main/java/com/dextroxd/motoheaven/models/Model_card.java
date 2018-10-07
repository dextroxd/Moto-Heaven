package com.dextroxd.motoheaven.models;

public class Model_card
{
    private String mImage;
    private String mName;
    private String mCost;
    private float mRating;

    public Model_card(String mImage, String mName, String mCost, float mRating)
    {
        this.mImage = mImage;
        this.mName = mName;
        this.mCost = mCost;
        this.mRating = mRating;
    }

    public String getmCost() {
        return mCost;
    }

    public String getmImage() {
        return mImage;
    }

    public String getmName() {
        return mName;
    }

    public float getmRating() {
        return mRating;
    }
}
