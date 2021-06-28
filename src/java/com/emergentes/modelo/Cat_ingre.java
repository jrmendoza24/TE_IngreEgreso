package com.emergentes.modelo;

import java.util.Date;

public class Cat_ingre {
    private int id_cat_ing ;
    private String nombre;
    private String fecha;

    public Cat_ingre(){
        this.id_cat_ing=0;
        this.nombre="";
        this.fecha="";
    }
    public int getId_cat_ing() {
        return id_cat_ing;
    }

    public void setId_cat_ing(int id_cat_ing) {
        this.id_cat_ing = id_cat_ing;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cat_ingre{" + "id_cat_ing=" + id_cat_ing + ", nombre=" + nombre + ", fecha=" + fecha + '}';
    }
    
}
