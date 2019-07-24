package com.custommvvm.model;

import android.util.Log;

import com.custommvvm.IBaseListener.ILoadListener;
import com.custommvvm.bean.DogBreed;
import com.custommvvm.bean.Dogs;
import com.custommvvm.network.HttpUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DogMode implements IDogModel {
    private  List<DogBreed> dogBreeds;


    @Override
    public void loadDogData(final ILoadListener listener) {
        HttpUtils.getDogsData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Dogs>() {
                    @Override
                    public void onNext(Dogs dogs) {
                        dogBreeds = dogs.getBreedsList();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        listener.complete(dogBreeds);
                    }
                });
    }

}
