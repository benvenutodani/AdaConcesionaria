package org.concesionaria.concesionaria.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "contrato")
public class Contrato {

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
    private Date fecha;

    private Double cuotas;

    @Column(nullable = false)
    private Double precio;

    public Contrato() {
    }

    public Contrato(Integer id, Cliente cliente,
                    Vendedor vendedor, Auto auto,
                    MetodoPago metodoPago, Date fecha,
                    Double cuotas, Double precio) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.cuotas = cuotas;
        this.precio = precio;
    }

    public Contrato(String cliente, String vendedor, String auto, String metodoPago, LocalDate parse, int i, Double precio) {
    }

    public Contrato(Cliente cliente, Vendedor vendedor, Auto auto, MetodoPago metodoPago,
                    Date fecha, Double cuotas, Double precio) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.cuotas = cuotas;
        this.precio = precio;
    }

    public Contrato(Cliente cliente, Vendedor vendedor, Auto auto, MetodoPago metodoPago,
                    Date fecha, Double cuotas) {
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCuotas() {
        return cuotas;
    }

    public void setCuotas(Double cuotas) {
        this.cuotas = cuotas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
