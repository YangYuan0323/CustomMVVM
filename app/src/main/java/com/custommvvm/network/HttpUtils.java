package com.custommvvm.network;


import com.custommvvm.bean.DogBreedImages;
import com.custommvvm.bean.Dogs;
import com.custommvvm.retrofitInterface.RetrofitInterface;
import com.custommvvm.util.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static final int DEFAULT_TIMEOUT = 8; //连接 超时的时间，单位：秒
    private static final OkHttpClient client = new OkHttpClient.Builder().
                                                    connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                                                    readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                                                    writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                                                    build();
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    private synchronized static RetrofitInterface getRetrofit(Gson gson) {
        //初始化retrofit的配置
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofitInterface = retrofit.create(RetrofitInterface.class);
        }
        return retrofitInterface;
    }


    public static Observable<Dogs> getDogsData() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Dogs.class, new JsonDogBreedsDeserializer())
                .create();
        return getRetrofit(gson).getDogsData();
    }

    public static Observable<DogBreedImages> getDogImageViewData(String breed) {
        return getRetrofit(null).getImagesByBreed(breed);
    }


}
