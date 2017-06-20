package com.example.pcportatil.shottyapp.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pcportatil.shottyapp.App;
import com.example.pcportatil.shottyapp.DetailActivity;
import com.example.pcportatil.shottyapp.DetailPromoActivity;
import com.example.pcportatil.shottyapp.MainActivity;
import com.example.pcportatil.shottyapp.MapsActivity;
import com.example.pcportatil.shottyapp.R;
import com.example.pcportatil.shottyapp.adapters.PromoAdapter;
import com.example.pcportatil.shottyapp.adapters.ReservaAdapter;
import com.example.pcportatil.shottyapp.adapters.RestauranteAdapter;
import com.example.pcportatil.shottyapp.databinding.FragmentMainBinding;
import com.example.pcportatil.shottyapp.models.Like;
import com.example.pcportatil.shottyapp.models.PromoEvento;
import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.ReservaDao;
import com.example.pcportatil.shottyapp.models.Restaurante;
import com.example.pcportatil.shottyapp.net.ReservaClient;
import com.example.pcportatil.shottyapp.net.RestaurantesClient;
import com.example.pcportatil.shottyapp.net.SimpleResponse;
import com.example.pcportatil.shottyapp.net.UsersClient;
import com.example.pcportatil.shottyapp.util.Data;
import com.example.pcportatil.shottyapp.util.Preference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements RestauranteAdapter.onRestauranteListener, PromoAdapter.onPromoEventoListener, RestauranteAdapter.onButtonListener, RestauranteAdapter.onLikesListener {

    FragmentMainBinding binding;
    RestauranteAdapter adapter;
    PromoAdapter adapter1;
    ReservaAdapter adapter2;
    RestaurantesClient client;
    ReservaClient client2;
    SharedPreferences preferences;
    ReservaDao dao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        preferences = getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapter2 = new ReservaAdapter(getLayoutInflater(null), new ArrayList<Reserva>());


        //region Creacion Adapters
        if (getArguments() != null) {
            int contenido = getArguments().getInt("contenido");

            switch (contenido) {

                case 1:

                    // adapter = new RestauranteAdapter(getLayoutInflater(null), new ArrayList<Restaurante>(), this); //res

                    adapter1 = new PromoAdapter(getLayoutInflater(null), new ArrayList<PromoEvento>(), this); //Eventos


                    break;
                case 2:

                    adapter = new RestauranteAdapter(getLayoutInflater(null), new ArrayList<Restaurante>(), this, this, this); //res

                    break;
                case 3:

                    adapter = new RestauranteAdapter(getLayoutInflater(null), new ArrayList<Restaurante>(), this, this, this); //dis
                    break;
                case 4:

                    adapter1 = new PromoAdapter(getLayoutInflater(null), new ArrayList<PromoEvento>(), this); //promociones
                    break;

            }

        }
        //endregion


        //region Adapter segun opcion seleccionada
        if (getArguments() != null) {
            int seleccion = getArguments().getInt("seleccion", 1);

            switch (seleccion) {

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
        //endregion
        client2 = App.retrofit.create(ReservaClient.class);
        client = App.retrofit.create(RestaurantesClient.class);
        dao = App.session.getReservaDao();

        return binding.getRoot();

    }


    public static MainFragment instance(int seleccion, int contenido) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("seleccion", seleccion);
        args.putInt("contenido", contenido);
        fragment.setArguments(args);

        return fragment;
    }

    //region onResume
    @Override
    public void onResume() {
        super.onResume();

        if (getArguments() != null) {
            int contenido = getArguments().getInt("contenido");

            switch (contenido) {

                case 1:

                    loadEventos();


                    break;
                case 2:

                    loadRest();

                    break;
                case 3:

                    loadDisco();
                    break;
                case 4:

                    loadPromo();
                    break;
                default:
                    Log.i("entra", "SI");
                    loadReservas();
                    break;

            }

        }


    }
    //endregion

    //region Load Datos
    private void loadRest() {
        Call<List<Restaurante>> request = client.allRes();
        request.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response.isSuccessful()) {
                    Data.restaurantes = response.body();
                    for (int i = 0; i < Data.restaurantes.size(); i++) {
                        Data.restaurantes.get(i).setTipo(2);

                    }

                    Log.d("tamalo", "" + Data.restaurantes.get(1).getNombre() + " imagen" + Data.restaurantes.get(1).getTipo());

                    adapter.setData(Data.restaurantes);
                }


            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
            }

        });


    }


    private void loadReservas() {
        String idusu = preferences.getString(Preference.KEY_USERID, "");
        Call<List<Reserva>> request = client2.allReservas(idusu);
        request.enqueue(new Callback<List<Reserva>>() {
            @Override
            public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
                if (response.isSuccessful()) {
                    Data.reservas = response.body();
                    adapter2.setData(Data.reservas);
                }


            }

            @Override
            public void onFailure(Call<List<Reserva>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
                List<Reserva> all = dao.loadAll();
                Data.reservas = all;
                adapter2.setData(Data.reservas);

            }

        });

    }


    private void loadDisco() {
        Call<List<Restaurante>> request = client.allDis();
        request.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response.isSuccessful()) {
                    Data.discotecas = response.body();
                    for (int i = 0; i < Data.discotecas.size(); i++) {
                        Data.discotecas.get(i).setTipo(1);

                    }

                    Log.d("tamalo", "" + Data.discotecas.get(1).getNombre() + " imagen" + Data.discotecas.get(1).getLikes());

                    adapter.setData(Data.discotecas);
                }


            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();

            }

        });
    }


    private void loadEventos() {
        Call<List<PromoEvento>> request = client.allEventos();
        request.enqueue(new Callback<List<PromoEvento>>() {
            @Override
            public void onResponse(Call<List<PromoEvento>> call, Response<List<PromoEvento>> response) {
                if (response.isSuccessful()) {
                    Data.eventos = response.body();
                    for (int i = 0; i < Data.eventos.size(); i++) {
                        Data.eventos.get(i).setTipo(2);

                    }
                    Log.d("tamalo", "" + Data.eventos.get(1).getLugar() + " imagen" + Data.eventos.get(1).getImagen());

                    adapter1.setData(Data.eventos);
                }


            }


            @Override
            public void onFailure(Call<List<PromoEvento>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
            }

        });
    }


    private void loadPromo() {
        Call<List<PromoEvento>> request = client.allPromo();
        request.enqueue(new Callback<List<PromoEvento>>() {
            @Override
            public void onResponse(Call<List<PromoEvento>> call, Response<List<PromoEvento>> response) {
                if (response.isSuccessful()) {
                    Data.promociones = response.body();
                    for (int i = 0; i < Data.promociones.size(); i++) {
                        Data.promociones.get(i).setTipo(1);

                    }
                    Log.d("tamalo", "" + Data.promociones.get(1).getLugar() + " imagen" + Data.promociones.get(1).getImagen());

                    adapter1.setData(Data.promociones);
                }


            }


            @Override
            public void onFailure(Call<List<PromoEvento>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
            }

        });


    }
    //endregion

    //region ButtonClicks
    @Override
    public void onRestauranteClick(int position, int tipoarray) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        if (tipoarray == 1) {
            intent.putExtra("pos", position);
            intent.putExtra("pos2", -1);

        } else {
            intent.putExtra("pos", -1);
            intent.putExtra("pos2", position);

        }
        startActivity(intent);
        int val = intent.getExtras().getInt("pos");



    }

    @Override
    public void onPromoEventoClick(int position, int tipoarray) {
        Intent intent = new Intent(getActivity(), DetailPromoActivity.class);

        if (tipoarray == 1) {
            intent.putExtra("pos1", position);
            intent.putExtra("pos3", -1);

        } else {
            intent.putExtra("pos1", -1);
            intent.putExtra("pos3", position);

        }
        startActivity(intent);
        int i = intent.getExtras().getInt("pos1");
        Log.d("bla", "" + i);

    }

    @Override
    public void onButtonClick(int position, int tipoArray) {
        Log.d("holanda", "" + position);
        Intent intent = new Intent(getActivity(), MapsActivity.class);

        if (tipoArray == 1) {
            intent.putExtra("pos", position);
            intent.putExtra("pos2", -1);

        } else {
            intent.putExtra("pos", -1);
            intent.putExtra("pos2", position);

        }
        startActivity(intent);
        int val = intent.getExtras().getInt("pos");
        Log.d("hola", "" + val);
    }
    //endregion


    @Override
    public void onLikesClick(int position, int tipoArray) {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        int likes;
        final String nombre;
        Log.i("tipoArray", "" + tipoArray);

        if (tipoArray == 2) {
            likes = Data.restaurantes.get(position).getLikes()+1;
            Like like = new Like(likes);
            nombre = Data.restaurantes.get(position).getNombre();

            Call<SimpleResponse> request = client.Reslikes(nombre,like);
            request.enqueue(new Callback<SimpleResponse>() {
                @Override
                public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                    if (response.isSuccessful()) {
                        loadRest();
                        SimpleResponse simpleResponse = response.body();
                        if (simpleResponse.isSuccess()){

                            Toast.makeText(getActivity(),"Me gusta "+nombre,Toast.LENGTH_SHORT).show();


                        }else {

                            Toast.makeText(getActivity(),"Me gusta "+nombre,Toast.LENGTH_SHORT).show();
                        }

                    }


                }

                @Override
                public void onFailure(Call<SimpleResponse> call, Throwable t) {
                    Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();

                }

            });


        } else {


            likes = Data.discotecas.get(position).getLikes()+1;
            Like like = new Like(likes);
            nombre = Data.discotecas.get(position).getNombre();

            Call<SimpleResponse> request = client.Dislikes(nombre,like);
            request.enqueue(new Callback<SimpleResponse>() {
                @Override
                public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                    if (response.isSuccessful()) {
                        loadDisco();
                        SimpleResponse simpleResponse = response.body();
                        if (simpleResponse.isSuccess()){

                            Toast.makeText(getActivity(), "Me gusta "+nombre,Toast.LENGTH_SHORT).show();


                        }else {

                            Toast.makeText(getActivity(),"Me gusta "+nombre,Toast.LENGTH_SHORT).show();
                        }

                    }


                }

                @Override
                public void onFailure(Call<SimpleResponse> call, Throwable t) {
               Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
                }

            });





        }

    }
}