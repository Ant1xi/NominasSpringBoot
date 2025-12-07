package com.antonio.nominas.repository;

import com.antonio.nominas.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    // ================== CONSULTAS ==================

    public List<Empleado> findAll() {
        String sql = "SELECT * FROM empleados";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Empleado.class));
    }

    public Empleado findByDni(String dni) {
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        return jdbc.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Empleado.class),
                dni
        );
    }

    // ================== INSERT ==================

    public int insert(Empleado e) {
        String sql = "INSERT INTO empleados (dni, nombre, sexo, categoria, anyos) " +
                "VALUES (?, ?, ?, ?, ?)";

        String sexoStr = (e.getSexo() != null) ? String.valueOf(e.getSexo()) : null;

        return jdbc.update(sql,
                e.getDni(),
                e.getNombre(),
                sexoStr,
                e.getCategoria(),
                e.getAnyos()
        );
    }

    // ================== UPDATE ==================

    public int update(Empleado e) {
        String sql = "UPDATE empleados " +
                "SET nombre = ?, sexo = ?, categoria = ?, anyos = ? " +
                "WHERE dni = ?";

        String sexoStr = (e.getSexo() != null) ? String.valueOf(e.getSexo()) : null;

        return jdbc.update(sql,
                e.getNombre(),
                sexoStr,
                e.getCategoria(),
                e.getAnyos(),
                e.getDni()
        );
    }

    // ================= CONSULTAR SALARIO =================
    
    public Double getSalarioByDni(String dni){
         String sql = "SELECT sueldo FROM nominas WHERE dni = ?";

         try {
             return jdbc.queryForObject(sql, Double.class, dni);
         } catch (EmptyResultDataAccessException e) {
             return null;
         }
    }
}
