package com.custommvvm.model;

import com.custommvvm.IBaseListener.ILoadListener;
import com.custommvvm.viewmodel.DogViewModel;

public interface IDogModel {

    void loadDogData(ILoadListener listener);

}
