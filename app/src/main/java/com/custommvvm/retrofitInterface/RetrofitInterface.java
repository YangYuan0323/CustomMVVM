package com.custommvvm.retrofitInterface;

import com.custommvvm.bean.DogBreedImages;
import com.custommvvm.bean.Dogs;
import com.custommvvm.util.Constant;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET(Constant.URL_PATH)
    Observable<Dogs> getDogsData();

    @GET(Constant.URL_IMAGES)
    Observable<DogBreedImages> getImagesByBreed(@Path("breed") String breed);
}
