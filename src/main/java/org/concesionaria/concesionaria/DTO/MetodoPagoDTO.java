package org.concesionaria.concesionaria.DTO;

public class MetodoPagoDTO {
    private String tipo;
    private String descripcion;
    private Integer id;
    public MetodoPagoDTO (String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId() {
        return id;
    }
}
