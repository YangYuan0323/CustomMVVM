package com.custommvvm.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class DogBreedImages {
    private String status;
    @SerializedName("message")
    private String [] images;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "DogBreedImages{" +
                "status='" + status + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
