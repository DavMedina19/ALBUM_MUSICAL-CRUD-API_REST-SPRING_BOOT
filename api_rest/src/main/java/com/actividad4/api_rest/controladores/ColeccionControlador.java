package com.actividad4.api_rest.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.actividad4.api_rest.modelos.Coleccion;
import com.actividad4.api_rest.servicios.ColeccionServicioImplement;

@RestController
@RequestMapping("/api/v1")
public class ColeccionControlador {

    @Autowired
    private ColeccionServicioImplement coleccionservicio;

    @GetMapping("/colecciones")
    public List<Coleccion> obtenerColecciones() {
        return coleccionservicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Coleccion> guardarColeccion(@RequestBody Coleccion coleccion) {
        Coleccion nueva_coleccion = coleccionservicio.guardar(coleccion);
        return new ResponseEntity<>(nueva_coleccion, HttpStatus.CREATED);
    }

    @GetMapping("/coleccion/{ID}")
    public ResponseEntity<Coleccion> obtenerColeccionID(@PathVariable long ID) {
        Coleccion coleccionPorID = coleccionservicio.obtenerPorId(ID);
        return ResponseEntity.ok(coleccionPorID);
    }

    @PutMapping("/coleccion/{ID}")
    public ResponseEntity<Coleccion> actualizar(@PathVariable long ID, @RequestBody Coleccion coleccion) {
        Coleccion coleccionPorID = coleccionservicio.obtenerPorId(ID);
        coleccionPorID.setTitulo(coleccion.getTitulo());
        coleccionPorID.setArtistas(coleccion.getArtistas());
        coleccionPorID.setGenero(coleccion.getGenero());
        coleccionPorID.setPrecioTotal(coleccion.getPrecioTotal());

        Coleccion coleccion_actualizada = coleccionservicio.guardar(coleccionPorID);
        return new ResponseEntity<>(coleccion_actualizada, HttpStatus.CREATED);
    }

    @DeleteMapping("/coleccion/{ID}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarColeccion(@PathVariable long ID) {
        this.coleccionservicio.eliminar(ID);
        HashMap<String, Boolean> estadoColeccionEliminada = new HashMap<>();
        estadoColeccionEliminada.put("eliminada", true);
        return ResponseEntity.ok(estadoColeccionEliminada);
    }
}
