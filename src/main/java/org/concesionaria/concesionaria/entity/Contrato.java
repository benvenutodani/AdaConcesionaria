package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name= "contrato")
public class Contrato {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendedor_id",nullable = false)
    private Vendedor vendedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_id",nullable = false)
    private Auto auto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="metodo_pago_id",nullable = false)
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private LocalDate fecha;

    private Double cuotas;

    @Column(nullable = false)
    private Double precio;


    public Contrato() {
    }

    public Contrato(Cliente cliente, Vendedor vendedor, Auto auto, MetodoPago metodoPago,
                    LocalDate fecha, Double cuotas) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.cuotas = cuotas;
    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Auto getAuto() {
        return auto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getCuotas() {
        return cuotas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCuotas(Double cuotas) {
        this.cuotas = cuotas;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public void modifyAttributeValue(String attributeName, Object newValue) {
        switch (attributeName) {
            case "cliente":
                this.cliente = (Cliente) newValue;
                break;
            case "vendedor":
                this.vendedor = (Vendedor) newValue;
                break;
            case "auto":
                this.auto = (Auto) newValue;
                break;
            case "metodo_pago":
                this.metodoPago = (MetodoPago) newValue;
                break;
            case "fecha":
                this.fecha= LocalDate.parse((String) newValue, DATE_TIME_FORMATTER);
                break;
            case "cuotas":
                this.cuotas = (Double) newValue;
                break;
        }
    }

}
