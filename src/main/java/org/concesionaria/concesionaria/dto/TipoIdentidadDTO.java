package org.concesionaria.concesionaria.dto;

public class TipoIdentidadDTO {

    private String tipo;
    private Integer id;

    public TipoIdentidadDTO(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getId() {
        return id;
    }
}
