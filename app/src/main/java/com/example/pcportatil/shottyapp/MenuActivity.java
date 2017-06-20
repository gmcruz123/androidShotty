package com.example.pcportatil.shottyapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.pcportatil.shottyapp.adapters.MenuAdapter;
import com.example.pcportatil.shottyapp.databinding.ActivityMainBinding;
import com.example.pcportatil.shottyapp.databinding.ActivityMenuBinding;
import com.example.pcportatil.shottyapp.models.Menu;
import com.example.pcportatil.shottyapp.util.Data;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;
    MenuAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        List<Menu> menu = new ArrayList<>();
        adapter = new MenuAdapter(getLayoutInflater(),menu);
        binding.list.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(Data.getMenus());
    }
}
