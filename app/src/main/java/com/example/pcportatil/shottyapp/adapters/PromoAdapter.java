package com.example.pcportatil.shottyapp.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.databinding.TemplatePromoEventosBinding;
import com.example.pcportatil.shottyapp.models.PromoEvento;

import java.util.List;

/**
 * Created by PC portatil on 09/06/2017.
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoHolder> {

    public interface onPromoEventoListener{
        void onPromoEventoClick(int position, int tipoarray);

    }

    LayoutInflater inflater;
    List<PromoEvento> data;
    onPromoEventoListener listener;


    public PromoAdapter (LayoutInflater inflater, List<PromoEvento> data, onPromoEventoListener listener){

        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public PromoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_promo_eventos,parent,false);
        return new PromoHolder(v);
    }

    @Override
    public void onBindViewHolder(PromoHolder holder, int position) {
        holder.binding.setPromoevento(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void onItemClick(int position, int tipoarray){

        listener.onPromoEventoClick(position,tipoarray);


    }

    //region view Holder
    static  class PromoHolder extends RecyclerView.ViewHolder{

        TemplatePromoEventosBinding binding;

        public PromoHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
    //endregion




}
