package com.example.pcportatil.shottyapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pcportatil.shottyapp.databinding.ActivityDetailPromoBinding;
import com.example.pcportatil.shottyapp.models.PromoEvento;
import com.example.pcportatil.shottyapp.util.Data;

public class DetailPromoActivity extends AppCompatActivity {
    ActivityDetailPromoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_promo);
        setSupportActionBar(binding.toolbar);

     if (getIntent().getExtras() != null) {

            int pos1 = getIntent().getExtras().getInt("pos1");
            int pos3 = getIntent().getExtras().getInt("pos3");
            Log.d("pos1 :", pos1+"pos2 :"+pos3);

            if (pos1 == -1){
                PromoEvento promo = Data.getPromoEventos(4).get(pos3);
                Log.d("mama", promo.getFecha());
                binding.setPromoevento(promo);

            }

            else{
               PromoEvento promo= Data.getPromoEventos(1).get(pos1);
                binding.setPromoevento(promo);
                Log.d("mama",promo.getFecha());
                }

            }


        }


}
