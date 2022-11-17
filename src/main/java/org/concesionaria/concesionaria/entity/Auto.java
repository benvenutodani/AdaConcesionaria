package org.concesionaria.concesionaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auto")
public class Auto {

    @Id
    @Column(name="numero_chasis")
    private String numeroChasis;

    @Column(nullable = false)
    private String modelo;

    @Column(name="anio_modelo", nullable = false)
    private Integer anioModelo;

    @Column(nullable = false)
    private String color;

    @Column(name="marca_id", nullable = false)
    private Integer marcaId;

    public Auto(){
    }

    public Auto(String numeroChasis, String modelo, Integer anioModelo, String color, Integer marcaId) {
        this.numeroChasis = numeroChasis;
        this.modelo = modelo;
        this.anioModelo = anioModelo;
        this.color = color;
        this.marcaId = marcaId;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnioModelo() {
        return anioModelo;
    }

    public String getColor() {
        return color;
    }

    public Integer getMarcaId() {
        return marcaId;
    }
}
