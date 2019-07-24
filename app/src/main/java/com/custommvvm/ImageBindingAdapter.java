package com.custommvvm;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.custommvvm.view.R;

public class ImageBindingAdapter {

    @BindingAdapter({"imageUrl"})
    public static void loadimage(ImageView imageView,String url){
        Log.e("TAG",url+"   -走到这里了");
        Glide.with(imageView.getContext()).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

}
