/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Autore;
import model.AutoreFactory;
import model.Libro;
import model.LibroFactory;

/**
 *
 * @author davide
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        
        
        HttpSession sessione = request.getSession();
        if(request.getParameter("login") != null){
            // ho premuto il pulsante login
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Autore autore = AutoreFactory.getInstance()
                    .getAutoreByEmailPassword(email, password);
            
            if(autore != null){
                sessione.setAttribute("autoreId", autore.getId());
            }
        }
        
        // qui ho autoreId inizializzato se l'ho appena fatto
        // oppure se l'ho fatto a una richiesta precedente
        if(sessione.getAttribute("autoreId") != null){
            int autoreId = (int) sessione.getAttribute("autoreId");
            Autore autore = AutoreFactory.getInstance()
                    .getAutoreById(autoreId);
            List<Libro> libri = LibroFactory.getInstance()
                    .getLibriAutore(autore);
            
            // passo alla jsp una variabile di nome autore, con valore un 
            // riferimento all'oggetto autore del codice della servlet
            request.setAttribute("autore", autore);
            
            request.setAttribute("libri", libri);
            // carica una jsp
            request.getRequestDispatcher("profilo_utente.jsp")
                    .forward(request, response);
        }else{
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
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
