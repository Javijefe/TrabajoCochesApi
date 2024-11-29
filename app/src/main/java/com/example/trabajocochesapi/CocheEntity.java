package com.example.trabajocochesapi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CocheEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marca;
    private String modelo;
    private String imagen;
    private String precio;
    private int anyo;

    //Lo necesita el room
    public CocheEntity() {
    }

    public CocheEntity(CochesResponse coches) {
        this.id = coches.getId();
        this.marca = coches.getMarca();
        this.modelo = coches.getModelo();
        this.imagen = coches.getImagenes();
        this.precio = coches.getPrecio();
        this.anyo = coches.getAnyo();
    }

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "CocheEntity{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio='" + precio + '\'' +
                ", anyo=" + anyo +
                '}';
    }
}
