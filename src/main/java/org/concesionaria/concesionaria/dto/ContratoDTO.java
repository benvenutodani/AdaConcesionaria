package org.concesionaria.concesionaria.dto;


import com.fasterxml.jackson.annotation.JsonAlias;

public class ContratoDTO {
    private Integer id;

    private String cliente;

    private String vendedor;

    private String auto;

    @JsonAlias("metodo_pago")
    private String metodoPago;

    private String fecha;

    private Integer cuotas;

    private Double precio;

    public ContratoDTO(String cliente, String vendedor, String auto,
                       String metodoPago, String fecha, Integer cuotas,
                       Double precio) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.cuotas = cuotas;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getAuto() {
        return auto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public Double getPrecio() {
        return precio;
    }
}
