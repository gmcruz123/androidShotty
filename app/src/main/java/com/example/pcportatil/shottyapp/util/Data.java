package com.example.pcportatil.shottyapp.util;

import android.view.Menu;

import com.example.pcportatil.shottyapp.models.PromoEvento;
import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by PC portatil on 07/06/2017.
 */

public class Data {


    public static List<Restaurante> restaurantes;
    public static List<Restaurante> discotecas;
    public static  List<PromoEvento> promociones;
    public static  List<Reserva> reservas;
    public static  List<PromoEvento> eventos;
    public static List<Integer> days ;
    public static List<Integer> horasini ;
    public static List<Integer> horasfin;
    public static List<Integer> days1; //disco
    public static List<Integer> horasini1;
    public  static List<Integer> horasfin1;
    public static List<com.example.pcportatil.shottyapp.models.Menu> menus;




    public static List<Integer> getHorasini() {
        horasini = new ArrayList<>();
        horasini.add(12);
        horasini.add(12);
        horasini.add(11);
        return horasini;
    }

    public static List<Integer> getHorasfin() {
        horasfin = new ArrayList<>();
        horasfin.add(25);
        horasfin.add(16);
        horasfin.add(23);
        return horasfin;
    }


    public static List<Integer> getHorasini1() {
        horasini1 = new ArrayList<>();
        horasini1.add(20);
        horasini1.add(20);

        return horasini1;
    }

    public static List<Integer> getHorasfin1(){
        horasfin1 = new ArrayList<>();
        horasfin1.add(28);
        horasfin1.add(28);
        return horasfin1;
    }

    public static List<com.example.pcportatil.shottyapp.models.Menu> getMenus() {
        menus = new ArrayList<>();
         com.example.pcportatil.shottyapp.models.Menu menu1 = new com.example.pcportatil.shottyapp.models.Menu();
        menu1.setNombre("Hamburguesa");
        menu1.setDescripcion("Hamburguesa doble queso, porcion de papas y adicion de guacamole");
        menu1.setImagen("https://i.ytimg.com/vi/0xziF-uu0Cg/maxresdefault.jpg");
        menu1.setPrecio("$ 18000");
        menus.add(menu1);


        com.example.pcportatil.shottyapp.models.Menu menu2 = new com.example.pcportatil.shottyapp.models.Menu();
        menu2.setNombre("Perro Caliente");
        menu2.setDescripcion("Perro caliente doble queso, porcion de papas y adicion de guacamole");
        menu2.setImagen("https://www.zenu.com.co/sites/default/files/recetas/receta-perro-con-agridulce-zenu.jpg");
        menu2.setPrecio("$ 12000");
        menus.add(menu2);


        com.example.pcportatil.shottyapp.models.Menu menu3 = new com.example.pcportatil.shottyapp.models.Menu();
        menu3.setNombre("Sandwich");
        menu3.setDescripcion("Sandwich doble queso, porcion de papas y adicion de guacamole");
        menu3.setImagen("https://cubanosguru-3b6d.kxcdn.com/wp-content/uploads/2016/04/sandwich-cubano.jpg");
        menu3.setPrecio("$ 18000");
        menus.add(menu3);


        com.example.pcportatil.shottyapp.models.Menu menu4 = new com.example.pcportatil.shottyapp.models.Menu();
        menu4.setNombre("Pollo apanado");
        menu4.setDescripcion("Pollo apanado, porcion de papas y adicion de guacamole");
        menu4.setImagen("http://www.mrpollo.com.ec/images/com_yoorecipe/originales/ninos/545_crocantes_horneadas.jpg");
        menu4.setPrecio("$ 18000");
        menus.add(menu4);


        com.example.pcportatil.shottyapp.models.Menu menu5 = new com.example.pcportatil.shottyapp.models.Menu();
        menu5.setNombre("Pizza");
        menu5.setDescripcion("La mejor pizza acompañada con salsa de ajo y mas ");
        menu5.setImagen("https://www.elementstark.com/woocommerce-extension-demos/wp-content/uploads/sites/2/2016/12/pizza.jpg");
        menu5.setPrecio("$ 14000");
        menus.add(menu5);

        com.example.pcportatil.shottyapp.models.Menu menu6 = new com.example.pcportatil.shottyapp.models.Menu();
        menu6.setNombre("Carne asada");
        menu6.setDescripcion("Carne asada con arroz, porcion de papas y adicion de guacamole");
        menu6.setImagen("http://www.almomento.mx/wp-content/uploads/2014/07/carne-asada.jpg");
        menu6.setPrecio("$ 28000");
        menus.add(menu6);



        return menus;
    }


/*    public static int tipo =0;

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
                p1.setImagen("http://www.universalmusica.com/wp-content/uploads/2015/09/daddy-yankee-sc3adgueme-y-te-sigo-daddy-yankee-video-oficial-video-import-640x360.jpg");
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
            p1.setImagen("http://www.billboard.com/files/media/Daddy-Yankee-Shaky-Shaky-baby-YIM-2016-billboard-1548.jpg");
            p1.setLugar("Boogie boogie");
            p1.setFecha("12/02/2017");
            p1.setHora("12:00");
            p1.setPersonas(9+"");

            reservas.add(p1);
        }
        return reservas;

    }




*/
}
