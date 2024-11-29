package com.example.trabajocochesapi;

import java.io.Serializable;


public class Coches implements Serializable {

    public int id;
    public String marca;
    public String precio;
    public String modelo;
    public String imagen;
    public int anyo;

/*
  Constructor que inicializa un objeto Coches a partir de un objeto CochesResponse.
  Este constructor se utiliza para convertir los datos obtenidos desde la API.
   */
    public Coches(CochesResponse cochesResponse){
        this.id=cochesResponse.getId();
        this.marca =cochesResponse.getMarca();
        this.modelo =cochesResponse.getModelo();
        this.imagen =cochesResponse.getImagenes();
        this.anyo =cochesResponse.getAnyo();
        this.precio =cochesResponse.getPrecio();
    }
    /*
  Constructor que inicializa un objeto Coches a partir de el objeto CocheEntity.
 Este constructor se utiliza para convertir datos almacenados localmente (en la base de datos).
     */
    public Coches(CocheEntity cocheEntity) {
        this.id=cocheEntity.getId();
        this.marca=cocheEntity.getMarca();
        this.modelo=cocheEntity.getModelo();
        this.precio=cocheEntity.getPrecio();
        this.anyo=cocheEntity.getAnyo();
        this.imagen=cocheEntity.getImagen();

    }

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "id=" + id +
                ", Marca='" + marca + '\'' +
                ", Precio='" + precio + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Imagenes='" + imagen + '\'' +
                ", Anyo=" + anyo +
                '}';
    }
}

