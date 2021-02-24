/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Controlador;
import negocio.Persona;

/**
 *
 * @author mile1
 */
public class Session extends HttpServlet {

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
        Controlador c = new Controlador();
        Persona p = c.getPersona();
        p.setDocumentoIdentidad(request.getParameter("usuario"));
        if (request.getParameter("usuario").equals("007")
                && request.getParameter("contrasena").equals("007")) {
            response.sendRedirect("./components/inicioAdmin.jsp");
        } else {
            try {

                c.BuscarPersona();
                String contra = p.getPrimerNombre() + p.getPrimerApellido();
                if (request.getParameter("contrasena").equals(contra)) {
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        session.invalidate();

                    }
                    session = request.getSession();

                    session.setAttribute("documento", p.getDocumentoIdentidad());

                    response.sendRedirect("components/inicio.jsp");

                } else {
                    response.sendRedirect("inicioSesion.jsp");

                }
            } catch (Exception e) {
                out.println("Usted no se encuentra registrado");
            }
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
