/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.controller;

import com.google.gson.Gson;
import com.tutoria16_07.daoImpl.VentaDaoImpl;
import com.tutoria16_07.entity.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VentaController extends HttpServlet {
private VentaDaoImpl venta = new VentaDaoImpl();
private Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int op = Integer.parseInt(request.getParameter("opc"));
        switch(op){
            case 1:  out.println(gson.toJson(venta.readAll()));
                            break;
            case 2:  out.println(gson.toJson(venta.create(new Venta(request.getParameter("fecha"), request.getParameter("tipodoc"), Integer.parseInt(request.getParameter("idsucursal")), Integer.parseInt(request.getParameter("idcliente"))))));
                            break;
            case 3:   Venta v = new Venta();
                            v.setIdventa(Integer.parseInt(request.getParameter("idventa")));
                            v.setFecha(request.getParameter("fecha"));
                            v.setTipodoc(request.getParameter("tipodoc"));
                            v.setIdsucursal(Integer.parseInt(request.getParameter("idsucursal")));
                            v.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                            out.println(gson.toJson(venta.update(v )));
                            break;
            case 4: out.println(gson.toJson(venta.delete(Integer.parseInt(request.getParameter("idventa")))));
                        break;
            case 5: out.println(gson.toJson(venta.read(Integer.parseInt(request.getParameter("idventa")))));
                        break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
