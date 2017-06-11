package com.example.pcportatil.shottyapp.util;

import com.example.pcportatil.shottyapp.models.PromoEvento;
import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC portatil on 07/06/2017.
 */

public class Data {

    private static List<Restaurante> restaurantes;
    private static List<Restaurante> discotecas;
    private static  List<PromoEvento> promociones;
    private static  List<Reserva> reservas;
    private static  List<PromoEvento> eventos;
     public static int tipo =0;

    public static List<Restaurante> getRestaurantes(int i ){
        if (i==2) {
        tipo =1;
            if (restaurantes == null) {
                restaurantes = new ArrayList<>();
                Restaurante r1 = new Restaurante();
                r1.setNombre("hola");
                r1.setImagen("http://servinox.com.mx/blog/wp-content/uploads/2015/03/Contemporary-Restaurant-Bar-Interior-Lighting-Design-Glass-House-Tavern-Manhattan-NYC.jpg");
                r1.setLikes("2 Likes");
                r1.setPlaceid("1223324");
                r1.setTipo(tipo);

                restaurantes.add(r1);

                Restaurante r2 = new Restaurante();
                r2.setNombre("Carantanta");
                r2.setImagen("https://www.buenamusica.com/media/fotos/cantantes/biografia/piso-21.jpg");
                r2.setLikes(2 + " Likes");
                r2.setPlaceid("13123");
                r2.setTipo(tipo);
                restaurantes.add(r2);


                Restaurante r3 = new Restaurante();
                r3.setNombre("boogie ");
                r3.setImagen("http://noticias.caracoltv.com/sites/default/files/styles/img_412x308/public/030217_nicky_jam_instagram.jpg?itok=qx9YDJsu&timestamp=1486138080");
                r3.setLikes(2 + " Likes");
                r3.setPlaceid("13123");
                r3.setTipo(tipo);
                restaurantes.add(r3);

            }

            return restaurantes;
        }


        else {
        tipo=2;
            if (discotecas == null) {
                discotecas = new ArrayList<>();
                Restaurante r1 = new Restaurante();
                r1.setNombre("Ay Caramba");
                r1.setImagen("http://www.viajarmiami.com/img/discotecas-famosas-miami.jpg");
                r1.setLikes("2 Likes");
                r1.setPlaceid("1223324");
                r1.setTipo(tipo);

                discotecas.add(r1);

                Restaurante r2 = new Restaurante();
                r2.setNombre("tropicalShots");
                r2.setImagen("https://www.discotecasmadrid.es/wp-content/uploads/2016/05/discotecas-gratis-madrid.jpg");
                r2.setLikes(2 + " Likes");
                r2.setPlaceid("13123");
                r2.setTipo(tipo);
                discotecas.add(r2);
            }
            return discotecas;

        }


    }



    public  static List<PromoEvento> getPromoEventos(int i ) {

        if (i == 1) {
            tipo=1;

            if (eventos == null) {
                eventos = new ArrayList<>();
                PromoEvento p1 = new PromoEvento();
                p1.setImagen("https://d1bq5g7z9i92ue.cloudfront.net/pictures/12/47/124730/Jazz.jpg");
                p1.setLugar("Boogie boogie");
                p1.setDescrip("bla bla bla ");
                p1.setFecha("15/02/2017");
                p1.setHora("12:00");
                p1.setInfo("dkhfkdhfkjshfk");
                p1.setTipo(1);
                eventos.add(p1);
            }
            return eventos;

        } else {

            tipo=2;
            if (promociones == null) {
                promociones = new ArrayList<>();
                PromoEvento p1 = new PromoEvento();
                p1.setImagen("https://d1bq5g7z9i92ue.cloudfront.net/pictures/12/47/124730/Jazz.jpg");
                p1.setLugar("Nicky jam");
                p1.setDescrip("bugga bugga  ");
                p1.setFecha("12/02/2017");
                p1.setHora("12:00");
                p1.setInfo("dkhfkdhfkjshfk");
                p1.setTipo(2);
                promociones.add(p1);

            }

            return promociones;
        }

    }



    public  static List<Reserva> getReservas( ){


        if (reservas == null){
            reservas = new ArrayList<>();
            Reserva p1 = new Reserva();
            p1.setImagen("https://d1bq5g7z9i92ue.cloudfront.net/pictures/12/47/124730/Jazz.jpg");
            p1.setLugar("Boogie boogie");
            p1.setFecha("12/02/2017");
            p1.setHora("12:00");
            p1.setPersonas(9+"");

            reservas.add(p1);
        }
        return reservas;

    }





}
