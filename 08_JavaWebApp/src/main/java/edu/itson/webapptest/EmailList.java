package edu.itson.webapptest;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.BOException;
import edu.itson.webapptest.negocio.impl.EmailListBO;
import edu.itson.webapptest.negocio.interfaces.IEmailListBO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toled
 */
@WebServlet(name = "EmailList", urlPatterns = {"/email-list"})
public class EmailList extends HttpServlet {

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

        String action = request.getParameter("action");

        /* Default Action */
        if (action == null || action.equalsIgnoreCase("find-all")) {
            this.processFindAll(request, response);
        }

    }

    private void processFindAll(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {

        IEmailListBO emailListBO = new EmailListBO();

        try {
            List<Email> emailList = emailListBO.findAll();
            request.setAttribute("emailList", emailList);
        } catch (BOException ex) {
            request.setAttribute("error", ex.getMessage());
            request
                    .getRequestDispatcher("/errorPage.jsp")
                    .forward(request, response);
            return;
        }
        getServletContext()
                .getRequestDispatcher("/pages/emails/email-list.jsp")
                .forward(request, response);
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

        /* Obtener datos */
        String action = request.getParameter("action");

        String paramEmail = request.getParameter("email");
        String paramUsername = request.getParameter("username");

        String paginaDestino = "/thanks.jsp";
        /* Validar Datos */
        if (paramEmail == null
                || paramEmail.isBlank()
                || paramEmail.trim().length() > 100
                || paramUsername == null
                || paramUsername.isBlank()
                || paramUsername.trim().length() > 50) {
            paginaDestino = "/register.jsp";
            getServletContext()
                    .getRequestDispatcher(paginaDestino)
                    .forward(request, response);
            return;
        }

        /* Logica de Negocio */
        Email email = new Email(paramEmail, paramUsername);
        IEmailListBO emailListBO = new EmailListBO();

        try {
            Email emailGuardado = emailListBO.create(email);
            request.setAttribute("email", emailGuardado);
        } catch (BOException ex) {
            request.setAttribute("error", ex.getMessage());
            request
                    .getRequestDispatcher("/errorPage.jsp")
                    .forward(request, response);
            return;
        }


        /* Generar respuesta */
        if (action == null) {
            action = "join";
        }

        if (action.equals("postEmail")) {

            paginaDestino = "/thanks.jsp";
            getServletContext()
                    .getRequestDispatcher(paginaDestino)
                    .forward(request, response);
            return;

        }

        if (action.equals("join")) {
            response.sendRedirect("index.html");
        }

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
