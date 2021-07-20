
package com.tutoria16_07.entity;

public class Cliente {
    
    private int idcliente;
    private String nombres;
    private String apellidos;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombres, String apellidos, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
