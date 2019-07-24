package com.custommvvm.bean;

import java.util.ArrayList;
import java.util.List;

public class Dogs {

    private String status;
    private List<DogBreed> breedsList = new ArrayList<>();


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DogBreed> getBreedsList() {
        return breedsList;
    }

    public void setBreedsList(List<DogBreed> breedsList) {
        this.breedsList = breedsList;
    }

    public void addBreed(DogBreed bd) {
        breedsList.add(bd);
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "status='" + status + '\'' +
                ", breedsList=" + breedsList +
                '}';
    }
}
