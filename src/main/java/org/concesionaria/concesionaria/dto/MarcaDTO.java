package org.concesionaria.concesionaria.dto;

import java.util.List;

public class MarcaDTO {

    private Integer id;

    private String nombre;

    private  String nacionalidad;

    public MarcaDTO() {
    }

    public MarcaDTO(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }


    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
