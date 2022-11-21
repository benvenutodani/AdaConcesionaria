package org.concesionaria.concesionaria.entity;


import javax.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String descripcion;


    public MetodoPago() {
    }

    public MetodoPago(Integer id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
