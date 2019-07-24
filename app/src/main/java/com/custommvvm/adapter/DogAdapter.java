package com.custommvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.custommvvm.DogViewHolder;
import com.custommvvm.bean.DogBreed;
import com.custommvvm.bean.DogBreedImages;
import com.custommvvm.network.HttpUtils;
import com.custommvvm.view.BR;
import com.custommvvm.view.R;
import com.custommvvm.view.databinding.ItemDogBinding;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DogAdapter extends RecyclerView.Adapter<DogViewHolder> {
    private List<DogBreed> dogBreeds = new ArrayList<>();
    private LayoutInflater inflater;

    public DogAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDogBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_dog, parent, false);
        return new DogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DogViewHolder holder, int position) {
        DogBreed dogBreed = dogBreeds.get(position);
        holder.getBind().setVariable(BR.dogBreed, dogBreed);
    }


    @Override
    public int getItemCount() {
        return dogBreeds != null?dogBreeds.size():0;
    }

    public void addDogBreeds(List<DogBreed> dogBreeds) {
        for (DogBreed dogBreed : dogBreeds) {
            getDogImageView(dogBreed,dogBreed.getBreed());
        }
    }

    public void getDogImageView(final DogBreed dogBreed, String dogImageUrl) {
        HttpUtils.getDogImageViewData(dogImageUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<DogBreedImages>() {
                    @Override
                    public void onNext(DogBreedImages images) {
                        String imageUrl = images.getImages()[0];
                        dogBreed.setImageUrl(imageUrl);
                        if(null != dogBreed){
                            dogBreeds.add(dogBreed);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        notifyDataSetChanged();
                    }
                });
    }
}
