package org.concesionaria.concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class VendedorDTO {

    private String cuil;

    private String nombre;

    private String apellido;

    @JsonAlias("numero_identidad")
    private String numeroIdentidad;

    @JsonAlias("tipo_identidad_id")
    private Integer tipoIdentidad;

    private String telefono;

    private String email;

    public VendedorDTO(String cuil, String nombre, String apellido,
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
}
