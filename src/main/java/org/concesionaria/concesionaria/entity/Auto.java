package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.util.List;

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
    @Column(nullable = false)
    private Double precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @OneToMany(mappedBy = "auto")
    private List<Contrato> contratos;

    public Auto (){
    }

    public Auto(String modelo, Integer anioModelo, String color, Double precio, Marca  marca) {

        this.modelo = modelo;
        this.anioModelo = anioModelo;
        this.color = color;
        this.precio=precio;
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

    public Double getPrecio() {
        return precio;
    }
}
