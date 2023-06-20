package edu.itson.webapptest;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.negocio.impl.EmailListBO;
import edu.itson.webapptest.negocio.interfaces.IEmailListBO;
import java.io.IOException;
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
        String mensaje = request.getParameter("mensaje");
        String paginaDestino = "/thanks.jsp";

        if (action == null) {
            action = "join";
        }

        if (action.equals("thanks")) {
//            getServerletContext().getRequestDispatcher
            request.setAttribute("mensaje", mensaje);
            getServletContext()
                    .getRequestDispatcher(paginaDestino)
                    .forward(request, response);
            return;

        }

        if (action.equals("formulario")) {
//            response.setStatus(404);
            response.sendRedirect("formulario.html");
        }

        if (action.equals("join")) {
            response.sendRedirect("index.html");
        }
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
                || paramEmail.trim().length() > 50
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
        Email emailGuardado = emailListBO.createEmail(email);

        /* Generar respuesta */
        if (action == null) {
            action = "join";
        }

        if (action.equals("postEmail")) {

            request.setAttribute("email", emailGuardado);

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
