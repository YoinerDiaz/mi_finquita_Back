package com.innovatexts.mi_finquita.dto;

import java.util.Date;

public class CultivoDTO {
    private Integer id; // Para lectura (GET), si quieres incluir el ID
    private String nombre;
    private String descripcion;
    private String tipo;
    private String variedad;
    private Date fecha_siembra;
    private Date fecha_cosecha;
    private float area_hectareas;
    private String ubicacion;
    private String estado;

    public CultivoDTO(){}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVariedad() {
        return this.variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public Date getFecha_siembra() {
        return this.fecha_siembra;
    }

    public void setFecha_siembra(Date fecha_siembra) {
        this.fecha_siembra = fecha_siembra;
    }

    public Date getFecha_cosecha() {
        return this.fecha_cosecha;
    }

    public void setFecha_cosecha(Date fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
    }

    public float getArea_hectareas() {
        return this.area_hectareas;
    }

    public void setArea_hectareas(float area_hectareas) {
        this.area_hectareas = area_hectareas;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
