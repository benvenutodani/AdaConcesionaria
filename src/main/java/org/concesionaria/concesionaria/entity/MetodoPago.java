package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "metodoPago")
    private List<Contrato> contratos;


    public MetodoPago() {
    }

    public MetodoPago( String tipo, String descripcion) {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "tipo":
                this.tipo = (String) newValue;
                break;
            case "descripcion":
                this.descripcion = (String) newValue;
                break;
        }
    }


}