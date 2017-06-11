package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 05/06/2017.
 */

public class PromoEvento {

    String fecha, hora , descrip, imagen , lugar, info;

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {

        return tipo;
    }

    int tipo;
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getImagen() {
        return imagen;
    }

    public String getLugar() {
        return lugar;
    }

    public String getInfo() {
        return info;
    }
}
