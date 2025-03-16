package com.innovatexts.mi_finquita.dto;

public class JwtResponseDTO {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String nombre;
    private String rol;
    
    public JwtResponseDTO(String token, Integer id, String username, String nombre, String rol) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.rol = rol;
    }
    
    // Getters y Setters
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}