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

    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private List<Auto> autos;

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

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public List<Auto> getAutos() {
        if (autos == null) {
            autos = new ArrayList<>();
        }

        return autos;
    }
}
