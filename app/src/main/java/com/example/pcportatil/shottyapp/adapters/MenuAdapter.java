package com.example.pcportatil.shottyapp.adapters;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.databinding.TemplateMenuBinding;
import com.example.pcportatil.shottyapp.models.Menu;

import java.util.List;

/**
 * Created by PC portatil on 20/06/2017.
 */

public class MenuAdapter  extends BaseAdapter{

    private LayoutInflater inflater;
    private List<Menu> data;


    public MenuAdapter(LayoutInflater inflater, List<Menu> data) {
        this.inflater = inflater;
        this.data = data;
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null)
            v = inflater.inflate(R.layout.template_menu, parent, false);

        TemplateMenuBinding binding = DataBindingUtil.bind(v);
        binding.setMenu(data.get(position));

        return binding.getRoot();
    }

    public void setData(List<Menu> data){
        this.data = data;
        notifyDataSetChanged();
    }
}
