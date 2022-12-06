package org.concesionaria.concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.concesionaria.concesionaria.entity.TipoIdentidad;

public class ClienteDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    @JsonAlias("numero_identidad")
    private String numeroIdentidad;

    @JsonAlias("tipo_identidad_id")
    private Integer tipoIdentidad;

    private String telefono;

    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellido, String numeroIdentidad, Integer tipoIdentidad, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.tipoIdentidad = tipoIdentidad;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
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
}

