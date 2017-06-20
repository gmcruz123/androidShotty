package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 04/06/2017.
 */

public class Restaurante {

    String nombre, placeid, imagen;
    int tipo, likes;
    float latitud, longitud;

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {

        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlaceid() {
        return placeid;
    }

    public String getImagen() {
        return imagen;
    }

    public int getLikes() {
        return likes;
    }
}
