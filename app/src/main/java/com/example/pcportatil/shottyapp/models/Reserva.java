package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 10/06/2017.
 */

public class Reserva {
    String lugar, imagen, fecha, hora, personas, ocasion, idusuario;

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getLugar() {
        return lugar;
    }

    public String getImagen() {
        return imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getPersonas() {
        return personas;
    }

    public String getOcasion() {
        return ocasion;
    }

    public String getIdusuario() {
        return idusuario;
    }
}
