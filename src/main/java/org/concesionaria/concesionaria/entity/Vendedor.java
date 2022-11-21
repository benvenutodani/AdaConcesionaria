package org.concesionaria.concesionaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(nullable = false)
    private String email;

    public Vendedor() {
    }

    public Vendedor(String cuil, String nombre, String apellido,
                    String numeroIdentidad, Integer tipoIdentidad,
                    String telefono, String email) {
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

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public Integer getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(Integer tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
