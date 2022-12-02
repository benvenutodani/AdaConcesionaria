package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="marca")
public class Marca {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String nacionalidad;


    public Marca() {
    }

    public Marca(Integer id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "nombre":
                this.nombre = (String) newValue;
                break;
            case "nacionalidad":
                this.nacionalidad = (String) newValue;
                break;
        }
    }

}
