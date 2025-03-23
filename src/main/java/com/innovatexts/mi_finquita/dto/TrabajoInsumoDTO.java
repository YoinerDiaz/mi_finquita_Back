package com.innovatexts.mi_finquita.dto;

public class TrabajoInsumoDTO {
    private Integer trabajoId;
    private Integer insumoId;
    private int cantidad;
    private float costoUnitario;

    public TrabajoInsumoDTO() {}

    public Integer getTrabajoId() {
        return trabajoId;
    }
    public void setTrabajoId(Integer trabajoId) {
        this.trabajoId = trabajoId;
    }
    public Integer getInsumoId() {
        return insumoId;
    }
    public void setInsumoId(Integer insumoId) {
        this.insumoId = insumoId;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float getCostoUnitario() {
        return costoUnitario;
    }
    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

}
