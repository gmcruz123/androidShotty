package com.example.pcportatil.shottyapp.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.databinding.TemplateRestauranteBinding;
import com.example.pcportatil.shottyapp.models.Restaurante;

import java.util.List;

/**
 * Created by PC portatil on 05/06/2017.
 */

public class RestauranteAdapter  extends  RecyclerView.Adapter<RestauranteAdapter.RestauranteHolder>{

    public interface onRestauranteListener{
        void onRestauranteClick(int position, int tipoArray);

    }

    LayoutInflater inflater;
    List<Restaurante> data;
    onRestauranteListener listener;

    public RestauranteAdapter(LayoutInflater inflater, List<Restaurante> data, onRestauranteListener listener) {
        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }




    @Override
    public RestauranteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_restaurante, parent, false);
        return new RestauranteHolder(v);
    }

    @Override
    public void onBindViewHolder(RestauranteHolder holder, int position) {
        holder.binding.setRestaurante(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
            //llena los datos
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onItemClick(int position, int tipoarray){

        listener.onRestauranteClick(position, tipoarray);


    }

    //region View Holders

    static  class RestauranteHolder extends RecyclerView.ViewHolder{

        TemplateRestauranteBinding binding;

        public RestauranteHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
    //endregion




}
