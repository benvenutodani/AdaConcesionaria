package org.concesionaria.concesionaria.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipo_identidad")
public class TipoIdentidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String tipo;



    public TipoIdentidad() {
    }

    public TipoIdentidad(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "tipo":
                this.tipo = (String) newValue;
                break;
        }
    }
}

