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
import com.tutoria16_07.entity.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentaDaoImpl implements Metodos<Venta>{
private PreparedStatement ps;
private ResultSet rs;
private Connection cx ;
    @Override
    public int create(Venta t) {
        int x = 0;
        String SQL = "INSERT INTO venta (fecha, tipodoc, idsucursal, idcliente) VALUES(?, ?, ?, ?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getFecha());
            ps.setString(2, t.getTipodoc());
            ps.setInt(3, t.getIdsucursal());
            ps.setInt(4, t.getIdcliente());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;
        
    }

    @Override
    public int update(Venta t) {
        int x = 0;
        String SQL = "UPDATE venta SET fecha = ?,  tipodoc = ?, idsucursal = ?, idcliente = ? WHERE idventa = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getFecha());
            ps.setString(2, t.getTipodoc());
            ps.setInt(3, t.getIdsucursal());
            ps.setInt(4, t.getIdcliente());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;     
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "DELETE FROM venta WHERE idventa = ?";
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
    public Venta read(int id) {
        Venta venta = new Venta();
        String SQL = "SELECT * from venta WHERE idventa =?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                venta.setIdventa(rs.getInt("idventa"));
                venta.setFecha(rs.getString("fecha"));
                venta.setTipodoc(rs.getString("tipodoc"));
                venta.setIdsucursal(rs.getInt("idsucursal"));
                venta.setIdcliente(rs.getInt("idcliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return venta;
    }

    @Override
    public List<Venta> readAll() {
                 return null;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
       List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "SELECT v.idventa as ID_VENTA, v.fecha as FECHA, v.tipodoc as DOCUMENTO_TIPO, s.nomsucursal as SUCURSAL, c.nombres as NOMBRE_C, c.apellidos as APELLIDOS_C from venta as v " +"join cliente as c on v.cliente =c.idcliente" + "join sucursal as s on v.idsucursal=s.idsucursal";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("idventa", rs.getInt("idventa"));
                map.put("fecha", rs.getString("fecha"));
                map.put("tipodoc", rs.getString("tipodoc"));
                map.put("idsucursal", rs.getInt("idsucursal"));
                map.put("idcliente", rs.getInt("idcliente"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;
    }
    
}
