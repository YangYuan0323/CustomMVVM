package com.custommvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class DogImage extends BaseObservable {
    private String imageUrl;

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DogImage{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
