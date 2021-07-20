/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.daoImpl;

import com.tutoria16_07.config.Conexion;
import com.tutoria16_07.dao.Metodos;
import com.tutoria16_07.entity.Cliente;
import com.tutoria16_07.entity.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteDaoImpl implements Metodos<Cliente>{
private PreparedStatement ps;
private ResultSet rs;
private Connection cx ;
    @Override
    public int create(Cliente t) {
        int x = 0;
        String SQL = "INSERT INTO cliente (nombres, apellidos, telefono) VALUES(?, ?, ?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getTelefono());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;
        
    }

    @Override
    public int update(Cliente t) {
        int x = 0;
        String SQL = "UPDATE cliente SET nombres = ?,  apellidos = ?, telefono = ? WHERE idcliente = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getTelefono());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;     
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "DELETE FROM cliente WHERE idcliente = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;            
    }

    @Override
    public Cliente read(int id) {
        Cliente cliente = new Cliente();
        String SQL = "SELECT * from cliente WHERE idcliente =?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return cliente;
    }

    @Override
    public List<Cliente> readAll() {
                 return null;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
       List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "SELECT c.idcliente as ID, c.nombres as nombres, c.apellidos as apellidos, c.telefono as telefono from cliente as c ";
        //+"inner join facultad as f on e.idfacultad =f.idfacultad"; --Llave foranea
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("idcliente", rs.getInt("idcliente"));
                map.put("nombres", rs.getString("nombres"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("telefono", rs.getString("telefono"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;
    }
    
}
