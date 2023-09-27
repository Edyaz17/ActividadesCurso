package com.pelicula;

public class Pelicula {
    private int id;
    private String nombre;
    private Boolean disponible;
    
    public Pelicula(){

    }

    public Pelicula (int id, String nombre, Boolean disponible){

        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean isDisponible() {
        return this.disponible;
    }

    public Boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }


}
