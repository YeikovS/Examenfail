/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.daoImpl;

import com.tutoria16_07.config.Conexion;
import com.tutoria16_07.dao.Metodos;
import com.tutoria16_07.entity.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dreyna
 */
public class SucursalDaoImpl implements Metodos<Sucursal>{
private PreparedStatement ps;
private ResultSet rs;
private Connection cx ;
    @Override
    public int create(Sucursal t) {
        int x = 0;
        String SQL = "INSERT INTO sucursal (nomsucursal) VALUES(?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNomsucursal());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;
    }

    @Override
    public int update(Sucursal t) {
        int x = 0;
        String SQL = "UPDATE sucursal SET nomsucursal WHERE idsucursal = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNomsucursal());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;  
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "DELETE FROM sucursal WHERE idsucursal = ?";
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
    public Sucursal read(int id) {
        Sucursal sucursal = new Sucursal();
        String SQL = "SELECT *from sucursal WHERE idsucursal =?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                sucursal.setIdsucursal(rs.getInt("idsucursal"));
                sucursal.setNomsucursal(rs.getString("nomsucursal"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return sucursal;
    }

    @Override
    public List<Sucursal> readAll() {
        List<Sucursal> lista = new ArrayList<>();
        String SQL = "select *from sucursal";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Sucursal f = new Sucursal();
                f.setIdsucursal(rs.getInt("idsucursal"));
                f.setNomsucursal(rs.getString("nomsucursal"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
