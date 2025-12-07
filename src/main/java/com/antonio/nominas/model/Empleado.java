package com.antonio.nominas.model;

public class Empleado {

    private Integer id;
    private String dni;
    private String nombre;
    private Character sexo;
    private Integer categoria;
    private Integer anyos;

    // Constructor vacío obligatorio para Spring / BeanPropertyRowMapper
    public Empleado() {
    }

    public Empleado(Integer id, String dni, String nombre,
                    Character sexo, Integer categoria, Integer anyos) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        this.categoria = categoria;
        this.anyos = anyos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getAnyos() {
        return anyos;
    }

    public void setAnyos(Integer anyos) {
        this.anyos = anyos;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", categoria=" + categoria +
                ", anyos=" + anyos +
                '}';
    }
}
