package com.custommvvm;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class DogViewHolder <T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;

    public DogViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBind() {
        return binding;
    }

}

