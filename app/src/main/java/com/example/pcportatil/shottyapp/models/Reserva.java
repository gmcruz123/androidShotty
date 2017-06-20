package com.example.pcportatil.shottyapp.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by PC portatil on 10/06/2017.
 */

@Entity
public class Reserva {
    @Id(autoincrement = true)
    Long id;


    String lugar, imagen, fecha, hora, personas, ocasion, idUsu;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }



    public Reserva(String lugar, String imagen, String fecha, String hora, String personas, String ocasion, String idUsu) {
        this.lugar = lugar;
        this.imagen = imagen;
        this.fecha = fecha;
        this.hora = hora;
        this.personas = personas;
        this.ocasion = ocasion;
        this.idUsu = idUsu;
    }


    @Generated(hash = 1163275905)
    public Reserva(Long id, String lugar, String imagen, String fecha, String hora, String personas, String ocasion,
            String idUsu) {
        this.id = id;
        this.lugar = lugar;
        this.imagen = imagen;
        this.fecha = fecha;
        this.hora = hora;
        this.personas = personas;
        this.ocasion = ocasion;
        this.idUsu = idUsu;
    }


    @Generated(hash = 961270578)
    public Reserva() {
    }



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

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
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

    public String getIdUsu() {
        return idUsu;
    }
}
