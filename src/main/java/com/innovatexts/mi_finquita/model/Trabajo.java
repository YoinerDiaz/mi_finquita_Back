package com.innovatexts.mi_finquita.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trabajo")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String detalles;



    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = true) // Puede ser null si no hay usuario asignado
    private Usuario usuario;

    private int trabajadoresContratados;
    private Date fechaInicio;
    private Date fechaFin;
    private float totalInversion;


    // Constructores
    public Trabajo() {}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDetalles() {
        return this.detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTrabajadoresContratados() {
        return this.trabajadoresContratados;
    }

    public void setTrabajadoresContratados(int trabajadoresContratados) {
        this.trabajadoresContratados = trabajadoresContratados;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getTotalInversion() {
        return this.totalInversion;
    }

    public void setTotalInversion(float totalInversion) {
        this.totalInversion = totalInversion;
    }
    

}
