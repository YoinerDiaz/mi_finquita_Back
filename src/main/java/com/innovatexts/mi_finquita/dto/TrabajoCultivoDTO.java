package com.innovatexts.mi_finquita.dto;

public class TrabajoCultivoDTO {
    private Integer trabajoId;
    private Integer cultivoId;
    // Si en el futuro quisieras más campos, los agregas aquí

    public TrabajoCultivoDTO() {
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
}
