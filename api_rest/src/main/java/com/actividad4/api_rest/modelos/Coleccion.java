package com.actividad4.api_rest.modelos;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colecciones")
public class Coleccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String Titulo;
    private String Artistas;
    private String Genero;
    private String PrecioTotal;

    public Coleccion() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getArtistas() {
        return Artistas;
    }

    public void setArtistas(String artistas) {
        Artistas = artistas;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        PrecioTotal = precioTotal;
    }
}
