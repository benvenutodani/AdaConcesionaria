package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.util.List;

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
    @Column(nullable = false)
    private Double precio;

    @JoinColumn(name = "marca_id", nullable = false)
    private Integer marcaId;

    @OneToMany(mappedBy = "auto")
    private List<Contrato> contratos;

    public Auto (){
    }

    public Auto(String numeroChasis, String modelo,
                Integer anioModelo, String color, Double precio, Integer marca) {
        this.numeroChasis = numeroChasis;
        this.modelo = modelo;
        this.anioModelo = anioModelo;
        this.color = color;
        this.precio = precio;
        this.marcaId = marca;
    }
    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "numero_chasis":
                this.numeroChasis = (String) newValue;
                break;
            case "modelo":
                this.modelo = (String) newValue;
                break;
            case "anio_modelo":
                this.anioModelo = (Integer) newValue;
                break;
            case "color":
                this.color = (String) newValue;
                break;
            case "precio":
                this.precio = (Double) newValue;
                break;
            case "marca_id":
                this.marcaId = (Integer) newValue;
                break;
        }
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

    public Double getPrecio() {
        return precio;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }
}
