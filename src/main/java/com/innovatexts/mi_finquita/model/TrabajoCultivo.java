package com.innovatexts.mi_finquita.model;

import jakarta.persistence.*;



@Entity
@Table(name = "trabajo_cultivo")
public class TrabajoCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con Trabajo
    @ManyToOne
    @JoinColumn(name = "id_trabajo")
    private Trabajo trabajo;

    // Relación con Cultivo
    @ManyToOne
    @JoinColumn(name = "id_cultivo")
    private Cultivo cultivo;

    public TrabajoCultivo() {}

    

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return Cultivo return the cultivo
     */
    public Cultivo getCultivo() {
        return cultivo;
    }

    /**
     * @param cultivo the cultivo to set
     */
    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

}

