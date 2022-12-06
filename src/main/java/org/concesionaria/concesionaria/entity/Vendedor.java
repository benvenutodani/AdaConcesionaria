package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    private String cuil;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "numero_identidad", nullable = false)
    private String numeroIdentidad;

    @Column(name = "tipo_identidad_id", nullable = false)
    private Integer tipoIdentidad;

    @Column(nullable = false)
    private String telefono;

    private String email;

    @OneToMany(mappedBy = "vendedor")
    private List<Contrato> contratos;

    public Vendedor() {
    }

    public Vendedor(String cuil, String nombre, String apellido, String numeroIdentidad,
                    Integer tipoIdentidad, String telefono) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.tipoIdentidad = tipoIdentidad;
        this.telefono = telefono;
    }

    public Vendedor(String cuil, String nombre, String apellido, String numeroIdentidad,
                    Integer tipoIdentidad, String telefono, String email) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.tipoIdentidad = tipoIdentidad;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCuil() {
        return cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public Integer getTipoIdentidad() {
        return tipoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public void setTipoIdentidad(Integer tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "cuil":
                this.cuil=(String) newValue;
            case "nombre":
                this.nombre = (String) newValue;
                break;
            case "apellido":
                this.apellido = (String) newValue;
                break;
            case "numero_idendtidad":
                this.numeroIdentidad = (String) newValue;
                break;
            case "tipo_identidad_id":
                this.tipoIdentidad= (Integer) newValue;
                break;
            case "telefono":
                this.telefono = (String) newValue;
                break;
            case "email":
                this.email = (String) newValue;
                break;
        }
    }
}
