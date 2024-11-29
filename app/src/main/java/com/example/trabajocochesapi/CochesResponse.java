package com.example.trabajocochesapi;

import com.google.gson.annotations.SerializedName;

public class CochesResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("Marca")
    private String marca;

    @SerializedName("Anyo")
    private int anyo;

    @SerializedName("Precio")
    private String precio;

    @SerializedName("Modelo")
    private String modelo;

    @SerializedName("Imagenes")
    private String imagenes;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }
}


