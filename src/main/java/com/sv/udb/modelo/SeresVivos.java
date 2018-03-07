/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class SeresVivos {
    
    private int codigoSV;
    private int codigoRef;
    private String nombreSV;
    private String descDV;

    public SeresVivos() {
    }

    public SeresVivos(int codigoSV, String nombreSV, String descDV, int codigoRef) {
        this.codigoSV = codigoSV;
        this.codigoRef = codigoRef;
        this.nombreSV = nombreSV;
        this.descDV = descDV;
    }

    public int getCodigoSV() {
        return codigoSV;
    }

    public void setCodigoSV(int codigoSV) {
        this.codigoSV = codigoSV;
    }

    public int getCodigoRef() {
        return codigoRef;
    }

    public void setCodigoRef(int codigoRef) {
        this.codigoRef = codigoRef;
    }

    public String getNombreSV() {
        return nombreSV;
    }

    public void setNombreSV(String nombreSV) {
        this.nombreSV = nombreSV;
    }

    public String getDescDV() {
        return descDV;
    }

    public void setDescDV(String descDV) {
        this.descDV = descDV;
    }

    @Override
    public String toString() {
        return nombreSV;
    }
    
    
    
    
    
}
