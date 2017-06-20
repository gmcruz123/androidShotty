package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 20/06/2017.
 */

public class Menu {
    String imagen, descripcion, precio,nombre;

    public Menu() {

    }

    public Menu(String imagen, String descripcion, String precio, String nombre) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
