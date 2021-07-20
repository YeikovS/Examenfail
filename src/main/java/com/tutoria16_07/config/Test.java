/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.config;

import com.google.gson.Gson;
//import com.tutoria16_07.daoImpl.ClienteDaoImpl;
//import com.tutoria16_07.daoImpl.SucursalDaoImpl;

/**
 *
 * @author dreyna
 */
public class Test {
//static ClienteDaoImpl client = new ClienteDaoImpl();
//static SucursalDaoImpl sucu = new SucursalDaoImpl();
//static SucursalDaoImpl sucu = new SucursalDaoImpl();
static Gson gson= new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("si");
        }
        else{
            System.out.println("No conectado");
        }
    }
    
}
