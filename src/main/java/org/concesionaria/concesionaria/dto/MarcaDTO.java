package org.concesionaria.concesionaria.dto;

import java.util.List;

public class MarcaDTO {

    private Integer id;
    private String nombre;
    private  String nacionalidad;

    private List<AutoDTO> autoDTOS;

    public MarcaDTO(Integer id, String nombre, String nacionalidad, List<AutoDTO> autoDTOS) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.autoDTOS = autoDTOS;
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

    public List<AutoDTO> getAutoDTOS() {
        return autoDTOS;
    }
}
