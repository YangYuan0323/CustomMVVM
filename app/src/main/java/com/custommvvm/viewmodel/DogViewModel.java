package com.custommvvm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.custommvvm.IBaseListener.ILoadListener;
import com.custommvvm.adapter.DogAdapter;
import com.custommvvm.bean.DogBreed;
import com.custommvvm.model.DogMode;

import java.util.List;

public class DogViewModel extends ViewModel implements ILoadListener {
    private DogAdapter adapter;
    private DogMode dogMode;

    public void init(DogAdapter adapter){
        this.adapter = adapter;
        dogMode = new DogMode();
        loadData();
    }

    private void loadData() {
        dogMode.loadDogData(this);
    }

    @Override
    public void complete(List<DogBreed> dogBreeds) {
        adapter.addDogBreeds(dogBreeds);
    }
}
