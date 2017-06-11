package com.example.pcportatil.shottyapp.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.databinding.TemplateReservacionesBinding;
import com.example.pcportatil.shottyapp.models.Reserva;

import java.util.List;

/**
 * Created by PC portatil on 10/06/2017.
 */

public class ReservaAdapter extends  RecyclerView.Adapter<ReservaAdapter.ReservaHolder> {

    LayoutInflater inflater;
    List<Reserva> data;


    public ReservaAdapter(LayoutInflater inflater, List<Reserva> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public ReservaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_reservaciones, parent, false);
        return new ReservaHolder(v);
    }

    @Override
    public void onBindViewHolder(ReservaHolder holder, int position) {
        holder.binding.setReserva(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    static  class ReservaHolder extends RecyclerView.ViewHolder{

        TemplateReservacionesBinding binding;

        public ReservaHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }

}
