package com.antonio.nominas.controller;

import com.antonio.nominas.excepciones.EmpleadoDataException;
import com.antonio.nominas.excepciones.FormatoDniException;
import com.antonio.nominas.excepciones.FormatoSexoException;
import com.antonio.nominas.model.Empleado;
import com.antonio.nominas.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

    private final EmpleadoService empleadoService;

    public EmpleadoRestController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // GET /api/empleados
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.findAll();
    }

    // GET /api/empleados/{dni}
    @GetMapping("/{dni}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable String dni) {
        Empleado empleado = empleadoService.findByDni(dni);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    // POST /api/empleados
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) throws FormatoDniException, FormatoSexoException, EmpleadoDataException {
        empleadoService.crearEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }
}
