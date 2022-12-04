package org.concesionaria.concesionaria.dto;


import com.fasterxml.jackson.annotation.JsonAlias;

public class ContratoDTO {
    private Integer id;
    @JsonAlias("cliente_id")
    private Integer cliente;
    @JsonAlias("vendedor_id")
    private String vendedor;
    @JsonAlias("auto_id")
    private String auto;

    @JsonAlias("metodo_pago")
    private Integer metodoPago;

    private String fecha;

    private Double cuotas;

    private Double precio;

    public ContratoDTO() {
    }

    public ContratoDTO(Integer cliente, String vendedor, String auto, Integer metodoPago, String fecha, Double cuotas, Double precio) {
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

    public Integer getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getAuto() {
        return auto;
    }

    public Integer getMetodoPago() {
        return metodoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getCuotas() {
        return cuotas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public void setMetodoPago(Integer metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCuotas(Double cuotas) {
        this.cuotas = cuotas;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}