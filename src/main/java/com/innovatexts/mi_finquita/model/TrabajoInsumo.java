package com.innovatexts.mi_finquita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajo_insumo")
public class TrabajoInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // <-- Debe coincidir con la PK de tu tabla

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "costoUnitario")
    private float costoUnitario;


    // Relación con Trabajo
    @ManyToOne
    @JoinColumn(name = "id_trabajo")
    private Trabajo trabajo;

    // Relación con Insumo
    @ManyToOne
    @JoinColumn(name = "id_insumo")
    private Insumo insumo;

    // Constructor vacío
    public TrabajoInsumo() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    /**
     * @return float return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return float return the costoUnitario
     */
    public float getCostoUnitario() {
        return costoUnitario;
    }

    /**
     * @param costoUnitario the costoUnitario to set
     */
    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    /**
     * @return Trabajo return the trabajo
     */
    public Trabajo getTrabajo() {
        return trabajo;
    }

    /**
     * @param trabajo the trabajo to set
     */
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    /**
     * @return Insumo return the insumo
     */
    public Insumo getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

}
