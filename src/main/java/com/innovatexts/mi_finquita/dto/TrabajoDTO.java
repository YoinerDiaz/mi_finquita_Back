package com.innovatexts.mi_finquita.dto;

import java.util.Date;

public class TrabajoDTO {

    private Integer id;  // Para lectura (GET), si quieres incluir el ID
    private String detalles;
    private Date fechaInicio;
    private Date fechaFin;
    private float totalInversion;
    private int trabajadoresContratados;
    private Integer usuarioId; // El ID del usuario asignado

    public TrabajoDTO() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public float getTotalInversion() {
        return totalInversion;
    }
    public void setTotalInversion(float totalInversion) {
        this.totalInversion = totalInversion;
    }
    public int getTrabajadoresContratados() {
        return trabajadoresContratados;
    }
    public void setTrabajadoresContratados(int trabajadoresContratados) {
        this.trabajadoresContratados = trabajadoresContratados;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
