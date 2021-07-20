/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.controller;

import com.google.gson.Gson;
import com.tutoria16_07.daoImpl.ClienteDaoImpl;
import com.tutoria16_07.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dreyna
 */
public class ClienteController extends HttpServlet {
private final ClienteDaoImpl client = new ClienteDaoImpl();
private final Gson gson = new Gson();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         int id = 0;
        int op = Integer.parseInt(request.getParameter("opc"));
        switch(op){
            case 1:  out.println(gson.toJson(client.readAll2()));
                            break;
            case 2:  out.println(gson.toJson(client.create(new Cliente(request.getParameter("nombres"),request.getParameter("apellidos"),request.getParameter("telefono")))));
                            break;
            case 3:   Cliente s = new Cliente();
                            s.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                            s.setNombres(request.getParameter("nombres"));
                            s.setApellidos(request.getParameter("apellidos"));
                            s.setTelefono(request.getParameter("telefono"));
                            out.println(gson.toJson(client.update(s )));
                            break;
            case 4: out.println(gson.toJson(client.delete(Integer.parseInt(request.getParameter("idcliente")))));
                        break;
            case 5: out.println(gson.toJson(client.read(Integer.parseInt(request.getParameter("idcliente")))));
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
