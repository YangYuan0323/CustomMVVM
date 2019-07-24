package com.custommvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class DogBreed extends BaseObservable {
    private String breed;

    private String imageUrl;

    public DogBreed(){};

    public DogBreed(String breed) {
        this.breed = breed;
    }

    @Bindable
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DogBreed{" +
                "breed='" + breed + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
