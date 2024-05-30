package com.actividad4.api_rest.servicios;

import java.util.List;
import com.actividad4.api_rest.modelos.Coleccion;


public interface IColeccionServicio {
    List<Coleccion> obtenerTodo();
    Coleccion guardar(Coleccion coleccion);
    Coleccion obtenerPorId(long ID);
    void eliminar(long ID);
}

