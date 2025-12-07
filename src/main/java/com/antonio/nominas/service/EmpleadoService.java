package com.antonio.nominas.service;

import com.antonio.nominas.excepciones.EmpleadoDataException;
import com.antonio.nominas.excepciones.FormatoDniException;
import com.antonio.nominas.excepciones.FormatoSexoException;
import com.antonio.nominas.model.Empleado;
import com.antonio.nominas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public void crearEmpleado(Empleado empleado)
            throws EmpleadoDataException, FormatoDniException, FormatoSexoException {

        validarEmpleado(empleado);
        empleadoRepository.insert(empleado);
    }

    public Double getSalarioByDni(String dni) throws FormatoDniException {

        comprobarDni(dni);
        return empleadoRepository.getSalarioByDni(dni);
    }

    public Empleado findByDni(String dni) {
        return empleadoRepository.findByDni(dni);
    }

    public int updateEmpleado(Empleado e) throws FormatoDniException, FormatoSexoException, EmpleadoDataException {
        validarEmpleado(e);
        return empleadoRepository.update(e);
    }

    // VALIDACIONES

    private void validarEmpleado(Empleado e)
            throws EmpleadoDataException, FormatoDniException, FormatoSexoException {

        comprobarDni(e.getDni());
        comprobarNombre(e.getNombre());
        comprobarSexo(e.getSexo());
        comprobarCategoria(e.getCategoria());
        comprobarAnyos(e.getAnyos());
    }

    private void comprobarDni(String dni) throws FormatoDniException {

        if (dni == null || dni.isBlank()) {
            throw new FormatoDniException("El DNI es obligatorio");
        }

        if (!dni.matches("^\\d{8}[A-Z]$")) {
            throw new FormatoDniException(
                    "Formato del DNI incorrecto: Deben ser 8 números seguidos de una letra en mayúscula");
        }
    }

    private void comprobarNombre(String nombre) throws EmpleadoDataException {

        if (nombre == null || nombre.isBlank()) {
            throw new EmpleadoDataException("El nombre es un campo obligatorio.");
        }

        if (!nombre.matches("^[A-ZÁÉÍÓÚÑ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚÑ][a-zñáéíóú]+)*$")) {
            throw new EmpleadoDataException(
                    "El nombre debe comenzar por mayúscula y seguir con minúsculas (se admiten nombres compuestos).");
        }
    }

    private void comprobarSexo(Character sexo)
            throws FormatoSexoException, EmpleadoDataException {

        if (sexo == null || Character.isWhitespace(sexo)) {
            throw new EmpleadoDataException("El sexo es un campo obligatorio.");
        }

        if (sexo != 'M' && sexo != 'F') {
            throw new FormatoSexoException("El sexo debe ser 'M' (hombre) o 'F' (mujer).");
        }
    }

    private void comprobarCategoria(Integer categoria) throws EmpleadoDataException {

        if (categoria == null) {
            throw new EmpleadoDataException("La categoría no puede ser un valor nulo");
        }

        if (categoria < 1 || categoria > 10) {
            throw new EmpleadoDataException("La categoría debe estar entre 1 y 10");
        }
    }

    private void comprobarAnyos(Integer anyos) throws EmpleadoDataException {

        if (anyos == null) {
            throw new EmpleadoDataException("Los años no pueden ser un valor nulo");
        }
        if (anyos < 0 || anyos > 99) {
            throw new EmpleadoDataException("Los años no pueden ser negativos ni excesivos");
        }
    }
}
