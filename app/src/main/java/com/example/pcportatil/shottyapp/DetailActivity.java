package com.example.pcportatil.shottyapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.pcportatil.shottyapp.databinding.ActivityDetailBinding;
import com.example.pcportatil.shottyapp.databinding.ActivityMainBinding;
import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.Restaurante;
import com.example.pcportatil.shottyapp.net.ReservaClient;
import com.example.pcportatil.shottyapp.net.SimpleResponse;
import com.example.pcportatil.shottyapp.util.Data;
import com.example.pcportatil.shottyapp.util.Preference;

import java.sql.Time;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener, Callback<SimpleResponse> {
    ActivityDetailBinding binding;
    Spinner opciones;
    Button btnfecha, btnhora,btnreservar;
    TextView fecha, hora;
    EditText personas;
    private int dia;
    private int mes;
    private int anio;
    private int hora1;
    private int minutos;
    private static int mes1;
    private static int diaSelec;
    private static int mesSelec;
    private static int anioSelec;
    private  int daygenerico;
    private static int tipo;
    public static String opcion;
    private static String lugar;
    private static String imagen;
    private static String fechafinal;
    private static String horafinal;
    ReservaClient client;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);
        client = ( (App)getApplication()).retrofit.create(ReservaClient.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);
        final Calendar cal = Calendar.getInstance();
        dia = cal.get(Calendar.DAY_OF_MONTH) ;
        mes1= cal.get(Calendar.MONTH)+1;
        anio= cal.get(Calendar.YEAR);
        daygenerico = cal.get(Calendar.DAY_OF_WEEK);

        if (getIntent().getExtras() != null) {

            int pos = getIntent().getExtras().getInt("pos");
            int pos2 = getIntent().getExtras().getInt("pos2");


            if (pos == -1) {
                Restaurante restaurante = Data.restaurantes.get(pos2);
                binding.setRestaurante(restaurante);
                tipo = Data.restaurantes.get(pos2).getTipo();
                lugar = Data.restaurantes.get(pos2).getNombre();
                imagen = Data.restaurantes.get(pos2).getImagen();
            }

            else  {
                Restaurante restaurante = Data.discotecas.get(pos);
                binding.setRestaurante(restaurante);
                tipo = Data.discotecas.get(pos).getTipo();
                lugar = Data.discotecas.get(pos).getNombre();
                imagen = Data.discotecas.get(pos).getImagen();
            }



        }

        btnfecha = (Button) findViewById(R.id.fecha);
        btnhora = (Button) findViewById(R.id.hora);
        hora = (TextView) findViewById(R.id.hora1);
        fecha = (TextView) findViewById(R.id.fecha1);
        opciones = (Spinner) findViewById(R.id.spinner2);
        btnreservar = (Button) findViewById(R.id.reservar1);
        personas = (EditText) findViewById(R.id.personas);

        btnfecha.setOnClickListener(this);
        btnhora.setOnClickListener(this);
        btnreservar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Fecha vencida!");

        builder.setMessage("Por favor ingrese una nueva fecha");
        builder.setPositiveButton("Aceptar",null);
        final Dialog dialog = builder.create();


        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("¡Hora fuera de rango!");

        builder1.setMessage("Por favor revise los horarios de Atencion del lugar");
        builder1.setPositiveButton("Aceptar",null);
        final Dialog dialog1 = builder1.create();

        if (view == btnfecha){
            Log.d("dedos","holanda");
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    diaSelec = i2;
                    mesSelec = i1+1;
                    anioSelec = i;



                    if (anioSelec == anio && mesSelec == mes1 && diaSelec>dia){
                        fecha.setText(i+"/"+mesSelec+"/"+i2);
                        fechafinal = i+"/"+mesSelec+"/"+i2;
                        Log.d("vocal","a");

                    }
                    else if (anioSelec == anio && mesSelec > mes1){
                        fecha.setText(i+"/"+mesSelec+"/"+i2);
                        fechafinal = i+"/"+mesSelec+"/"+i2;
                        Log.d("vocal","b"+mes);}

                    else if (anioSelec>anio){
                        fecha.setText(i+"/"+mesSelec+"/"+i2);
                        fechafinal = i+"/"+mesSelec+"/"+i2;
                        Log.d("vocal","c"+mes);
                        }


                    else {

                        dialog.show();

                    }



                }
            },anio,mes,dia);
            datePickerDialog.show();
        }

        else if (view == btnhora){
            final Calendar calendar = Calendar.getInstance();
            hora1 = calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {


                    //hora.setText(i + ":" + i1);
                    if (tipo == 1) {

                        if (Data.getHorasini1().get(0) <= i && i <= Data.getHorasfin1().get(0)) {

                            hora.setText(i + ":" + i1);
                            horafinal = i + ":" + i1;

                        } else {

                            dialog1.show();
                        }
                    }

                    else
                    {
                        if (Data.getHorasini().get(0) <= i && i <= Data.getHorasfin().get(0)) {

                            hora.setText(i + ":" + i1);
                            horafinal = i + ":" + i1;

                        } else {

                            dialog1.show();
                        }


                    }

                }
            },hora1,mes,false);
            timePickerDialog.show();

        }

        else if (view== btnreservar){
            reservar();
        }



    }



    public void reservar(){
        SharedPreferences preferences;
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME,MODE_PRIVATE);
        String idusu = preferences.getString(Preference.KEY_USERID,"");

        opcion = opciones.getSelectedItem().toString();
        Log.i("dedos","asdad"+opcion);

        Reserva reserva = new Reserva(lugar,imagen,fechafinal,horafinal,personas.getText().toString(),opcion,idusu);

        Call<SimpleResponse> request = client.reservacion(reserva);
        request.enqueue(this);

    }


    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if (response.isSuccessful()){
            SimpleResponse simpleResponse = response.body();
            if (simpleResponse.isSuccess()){

                Toast.makeText(this,simpleResponse.getMsg(),Toast.LENGTH_SHORT);


            }else {

                Toast.makeText(this,simpleResponse.getMsg(),Toast.LENGTH_SHORT);
            }

        }

        else{
            Toast.makeText(this,"No se ha encontrado reservas",Toast.LENGTH_SHORT);

        }



    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {


        Toast.makeText(this,"Por favor revise su conexion a Internet",Toast.LENGTH_SHORT);

    }
}
