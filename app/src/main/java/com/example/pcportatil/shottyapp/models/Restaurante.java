package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 04/06/2017.
 */

public class Restaurante {

    String nombre, placeid, imagen,likes;
    int tipo;

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

    public void setLikes(String likes) {
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

    public String getLikes() {
        return likes;
    }
}
