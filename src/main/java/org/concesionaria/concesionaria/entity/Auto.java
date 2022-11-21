package org.concesionaria.concesionaria.entity;

import javax.persistence.*;

@Entity
@Table(name="auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero_chasis")
    private String numeroChasis;

    @Column(nullable = false)
    private String modelo;

    @Column(name="anio_modelo", nullable = false)
    private Integer anioModelo;

    @Column(nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Auto (){
    }

    public Auto(String modelo, Integer anioModelo, String color, Marca  marca) {

        this.modelo = modelo;
        this.anioModelo = anioModelo;
        this.color = color;
        this.marca= marca;
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

    public Marca getMarca() {
        return marca;
    }

}
