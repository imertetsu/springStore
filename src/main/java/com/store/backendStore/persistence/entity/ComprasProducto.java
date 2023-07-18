package com.store.backendStore.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private BigDecimal total;
    private Boolean estado;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ComprasProducto{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", estado=" + estado +
                '}';
    }
}
