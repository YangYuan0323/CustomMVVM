package com.custommvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.custommvvm.adapter.DogAdapter;
import com.custommvvm.bean.DogBreed;
import com.custommvvm.view.databinding.ActivityMainBinding;
import com.custommvvm.viewmodel.DogViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<DogBreed> dogBreeds;
    private DogViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData(savedInstanceState);
    }



    private void initView() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = ViewModelProviders.of(this).get(DogViewModel.class);

    }

    private void initData(Bundle savedInstanceState) {
        dogBreeds = new ArrayList<>();
        dogBreeds.add(new DogBreed("白面包"));
        dogBreeds.add(new DogBreed("奶油面包"));
//        DogAdapter adapter = new DogAdapter(this, dogBreeds);
        DogAdapter adapter = new DogAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        if(null == savedInstanceState){
            viewModel.init(adapter);
        }
    }
}
