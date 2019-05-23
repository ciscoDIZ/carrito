/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.carrito.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "DETALLE_PEDIDOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedidos.findAll", query = "SELECT d FROM DetallePedidos d")
    , @NamedQuery(name = "DetallePedidos.findById", query = "SELECT d FROM DetallePedidos d WHERE d.id = :id")
    , @NamedQuery(name = "DetallePedidos.findByCantidad", query = "SELECT d FROM DetallePedidos d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallePedidos.findByPrecio", query = "SELECT d FROM DetallePedidos d WHERE d.precio = :precio")})
public class DetallePedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne
    private Clientes idCliente;
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    @ManyToOne
    private Productos idProducto;

    public DetallePedidos() {
    }

    public DetallePedidos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidos)) {
            return false;
        }
        DetallePedidos other = (DetallePedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ciscodiz.carrito.modelo.DetallePedidos[ id=" + id + " ]";
    }
    
}
