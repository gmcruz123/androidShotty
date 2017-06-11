package com.example.pcportatil.shottyapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pcportatil.shottyapp.databinding.ActivityDetailBinding;
import com.example.pcportatil.shottyapp.databinding.ActivityMainBinding;
import com.example.pcportatil.shottyapp.models.Restaurante;
import com.example.pcportatil.shottyapp.util.Data;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);

        if (getIntent().getExtras() != null) {

            int pos = getIntent().getExtras().getInt("pos");
            int pos2 = getIntent().getExtras().getInt("pos2");


            if (pos == -1) {
                Restaurante restaurante = Data.getRestaurantes(1).get(pos2);
                binding.setRestaurante(restaurante);
            }

            else  {
                Restaurante restaurante = Data.getRestaurantes(2).get(pos);
                binding.setRestaurante(restaurante);

            }



        }

    }
}
