package com.innovatexts.mi_finquita.dto;

public class TrabajoCultivoDTO {
    private Integer id;
    private Integer trabajoId;
    private Integer cultivoId;
    private String trabajoNombre;
    private String cultivoNombre;
    // Si en el futuro quisieras más campos, los agregas aquí

    public TrabajoCultivoDTO(String trabajoNombre, String cultivoNombre) {
        this.trabajoNombre = trabajoNombre;
        this.cultivoNombre = cultivoNombre;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTrabajoId() {
        return trabajoId;
    }

    public void setTrabajoId(Integer trabajoId) {
        this.trabajoId = trabajoId;
    }

    public Integer getCultivoId() {
        return cultivoId;
    }

    public void setCultivoId(Integer cultivoId) {
        this.cultivoId = cultivoId;
    }

    public String getTrabajoNombre() {
        return trabajoNombre;
    }

    public void setTrabajoNombre(String trabajoNombre) {
        this.trabajoNombre = trabajoNombre;
    }

    public String getCultivoNombre() {
        return cultivoNombre;
    }

    public void setCultivoNombre(String cultivoNombre) {
        this.cultivoNombre = cultivoNombre;
    }
}
