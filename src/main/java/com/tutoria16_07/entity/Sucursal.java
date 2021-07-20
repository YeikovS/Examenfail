/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.entity;

/**
 *
 * @author dreyna
 */
public class Sucursal {
    private int idsucursal;
    private String nomsucursal;

    public Sucursal() {
    }

    public Sucursal(String nomsucursal) {
        this.nomsucursal = nomsucursal;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNomsucursal() {
        return nomsucursal;
    }

    public void setNomsucursal(String nomsucursal) {
        this.nomsucursal = nomsucursal;
    }


}
