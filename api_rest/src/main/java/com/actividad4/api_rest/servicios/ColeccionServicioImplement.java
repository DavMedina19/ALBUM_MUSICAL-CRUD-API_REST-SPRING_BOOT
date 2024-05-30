package com.actividad4.api_rest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad4.api_rest.modelos.Coleccion;
import com.actividad4.api_rest.repositorios.ColeccionRepositorio;


@Service
public class ColeccionServicioImplement implements IColeccionServicio {

    @Autowired
    private ColeccionRepositorio coleccionrepositorio;

    @Override
    public List<Coleccion> obtenerTodo() {
        return coleccionrepositorio.findAll();
    }

    @Override
    public Coleccion guardar(Coleccion coleccion) {
        return coleccionrepositorio.save(coleccion);
    }

    @Override
    public Coleccion obtenerPorId(long ID) {
        return coleccionrepositorio.findById(ID).orElse(null);
    }

    @Override
    public void eliminar(long ID) {
        coleccionrepositorio.deleteById(ID);
    }
}
