package org.concesionaria.concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ClienteDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    @JsonAlias("numero_identidad")
    private String numeroIdentidad;

    @JsonAlias("tipo_identidad_id")
    private String tipoIdentidad;

    private String telefono;

    private String email;

    public ClienteDTO(String nombre, String apellido, String numeroIdentidad, String tipoIdentidad, String telefono, String email) {
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

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
