package com.actividad4.api_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.actividad4.api_rest.modelos.Coleccion;


@Repository
public interface ColeccionRepositorio extends JpaRepository<Coleccion, Long> {
}
