package com.custommvvm.IBaseListener;

import com.custommvvm.bean.DogBreed;

import java.util.List;

public interface ILoadListener {

    void complete(List<DogBreed> dogBreeds);
}
