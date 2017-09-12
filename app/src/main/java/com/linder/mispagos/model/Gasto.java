package com.linder.mispagos.model;

/**
 * Created by linderhassinger on 9/7/17.
 */

public class Gasto {

    private String detalle;
    private Double monto;

    public Gasto() {
    }

    public Gasto(String detalle, Double monto) {
        this.detalle = detalle;
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "detalle='" + detalle + '\'' +
                ", monto=" + monto +
                '}';
    }
}
