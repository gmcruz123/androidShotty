package com.example.pcportatil.shottyapp.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pcportatil.shottyapp.DetailActivity;
import com.example.pcportatil.shottyapp.DetailPromoActivity;
import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.adapters.PromoAdapter;
import com.example.pcportatil.shottyapp.adapters.ReservaAdapter;
import com.example.pcportatil.shottyapp.adapters.RestauranteAdapter;
import com.example.pcportatil.shottyapp.databinding.FragmentMainBinding;
import com.example.pcportatil.shottyapp.util.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements RestauranteAdapter.onRestauranteListener, PromoAdapter.onPromoEventoListener {

    FragmentMainBinding binding;
    RestauranteAdapter adapter;
    PromoAdapter adapter1;
    ReservaAdapter adapter2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false);
        adapter2 = new ReservaAdapter(getLayoutInflater(null), Data.getReservas());


        if (getArguments() != null){
            int contenido = getArguments().getInt("contenido");

            switch (contenido){

                case 1:

                    adapter1 = new PromoAdapter(getLayoutInflater(null), Data.getPromoEventos(1), this);
                    break;
                case 2:

                    adapter = new RestauranteAdapter(getLayoutInflater(null), Data.getRestaurantes(2), this);
                    break;
                case 3:

                    adapter = new RestauranteAdapter(getLayoutInflater(null), Data.getRestaurantes(3), this);
                    break;
                case 4:

                    adapter1 = new PromoAdapter(getLayoutInflater(null), Data.getPromoEventos(4), this);
                    break;

            }


        }



        if (getArguments() != null){
            int seleccion = getArguments().getInt("seleccion",1);

            switch (seleccion){

                 case 1:

                     binding.recycler.setAdapter(adapter1);

                     break;
                 case 2:

                     binding.recycler.setAdapter(adapter);

                     break;
                 case 3:
                     binding.recycler.setAdapter(adapter2);

                     break;


             }


            binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        }


        return binding.getRoot();

    }


    public static MainFragment instance (int seleccion, int contenido ){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("seleccion",seleccion );
        args.putInt("contenido", contenido);
        fragment.setArguments(args);

        return  fragment;
    }


    @Override
    public void onRestauranteClick(int position, int tipoarray) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        if (tipoarray == 1 ){
            intent.putExtra("pos",position);
            intent.putExtra("pos2",-1);

        }
        else {
            intent.putExtra("pos",-1);
            intent.putExtra("pos2",position);

        }
        startActivity(intent);
       int  val = intent.getExtras().getInt("pos");
        Log.d("hola",""+val);


    }

    @Override
    public void onPromoEventoClick(int position, int tipoarray) {
        Intent intent = new Intent(getActivity(), DetailPromoActivity.class);

        if (tipoarray == 1 ){
            intent.putExtra("pos1",position);
            intent.putExtra("pos3",-1);

        }
        else {
            intent.putExtra("pos1",-1);
            intent.putExtra("pos3",position);

        }
        startActivity(intent);
        int i = intent.getExtras().getInt("pos1");
        Log.d("bla",""+i);

    }
}
