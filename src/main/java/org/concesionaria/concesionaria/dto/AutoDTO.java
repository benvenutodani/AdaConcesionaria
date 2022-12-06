package org.concesionaria.concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AutoDTO {

    @JsonAlias("numero_chasis")
    private String numeroChasis;

    private String modelo;

    @JsonAlias ("marca_id")
    private Integer marcaId;

    @JsonAlias ("anio_modelo")
    private Integer anioModelo;

    private String color;

    private Double precio;

    private Boolean vendido;

    public AutoDTO() {
    }

    public AutoDTO(String numeroChasis, String modelo,
                   Integer marcaId, Integer anioModelo, String color, Double precio) {
        this.numeroChasis = numeroChasis;
        this.modelo = modelo;
        this.marcaId = marcaId;
        this.anioModelo = anioModelo;
        this.color = color;
        this.precio = precio;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public Integer getAnioModelo() {
        return anioModelo;
    }

    public String getColor() {
        return color;
    }

    public Double getPrecio() {
        return precio;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public void setAnioModelo(Integer anioModelo) {
        this.anioModelo = anioModelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }
}
