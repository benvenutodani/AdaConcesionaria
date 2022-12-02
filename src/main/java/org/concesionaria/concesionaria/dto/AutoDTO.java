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



    public AutoDTO(String numeroChasis, String modelo,
                   Integer marcaId, Integer anioModelo, String color, Double precio) {
        this.numeroChasis = numeroChasis;
        this.modelo = modelo;
        this.marcaId = marcaId;
        this.anioModelo = anioModelo;
        this.color = color;
        this.precio = precio;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }
    public String getNumeroChasis() {
        return numeroChasis;
    }
    public String getModelo() {
        return modelo;
    }

    public Integer getMarcaId(){return marcaId;}

    public Integer getAnioModelo() {
        return anioModelo;
    }

    public String getColor(){
        return color;
    }

    public Double getPrecio() {return precio;}
}
