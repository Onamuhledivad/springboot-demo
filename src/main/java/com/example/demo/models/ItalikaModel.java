package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class ItalikaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private String sku;
    private String fert;
    private String modelo;
    private String tipo;
    private Long no_serie;
    private String fecha;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getFert() {
        return fert;
    }
    public void setFert(String fert) {
        this.fert = fert;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Long getNo_serie() {
        return no_serie;
    }
    public void setNo_serie(Long no_serie) {
        this.no_serie = no_serie;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
