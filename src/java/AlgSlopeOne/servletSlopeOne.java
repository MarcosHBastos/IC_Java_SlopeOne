/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgSlopeOne;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "servletSlopeOne.java", urlPatterns = {"/servletSlopeOne"})
public class servletSlopeOne extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("".equals(request.getParameter("input6"))) {
             servletSOnePrevCall(request, response);
        } else {
            if (Integer.parseInt(request.getParameter("method")) == 1) {
                servletSOneCall(request, response);
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }

    protected void servletSOneCall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double inputs[] = new double[5];
        inputs[0] = Double.parseDouble(request.getParameter("input1").replaceAll(",", "."));
        inputs[1] = Double.parseDouble(request.getParameter("input2").replaceAll(",", "."));
        inputs[2] = Double.parseDouble(request.getParameter("input3").replaceAll(",", "."));
        inputs[3] = Double.parseDouble(request.getParameter("input4").replaceAll(",", "."));
        inputs[4] = Double.parseDouble(request.getParameter("input5").replaceAll(",", "."));
        double inputPrev = Double.parseDouble(request.getParameter("input6").replaceAll(",", "."));
        response.setContentType("text/html");

        Usuario sessionU = new Usuario(inputs);
        double prev = SlopeOne.slopeOne(sessionU, 6);
        DecimalFormat formato = new DecimalFormat("#,##");
        prev = Double.valueOf(formato.format(prev));
        Registro.setNewUsuario(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputPrev, prev);
        //Registro.setErroNewUsuario(7);
        request.setAttribute("previsao", prev);
        request.setAttribute("inputPrev", inputPrev);
        //request.getParameter("form").reset();
        request.getRequestDispatcher("/resultado.jsp").forward(request, response);

    }
    
    protected void servletSOnePrevCall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double inputs[] = new double[5];
        inputs[0] = Double.parseDouble(request.getParameter("input1").replaceAll(",", "."));
        inputs[1] = Double.parseDouble(request.getParameter("input2").replaceAll(",", "."));
        inputs[2] = Double.parseDouble(request.getParameter("input3").replaceAll(",", "."));
        inputs[3] = Double.parseDouble(request.getParameter("input4").replaceAll(",", "."));
        inputs[4] = Double.parseDouble(request.getParameter("input5").replaceAll(",", "."));
        response.setContentType("text/html");

        Usuario sessionU = new Usuario(inputs);
        double prev = SlopeOne.slopeOne(sessionU, 6);
        DecimalFormat formato = new DecimalFormat("#,##");
        prev = Double.valueOf(formato.format(prev));
        Registro.setNewUsuario(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], prev, prev);
        //Registro.setErroNewUsuario(7);
        request.setAttribute("previsao", prev);
        //request.setAttribute("inputPrev", inputPrev);
        //request.getParameter("form").reset();
        request.getRequestDispatcher("/resultado2.jsp").forward(request, response);

    }

    /*  protected void servletPrevErro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double erro = 0;
            
        }
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletSlopeOne</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletSlopeOne at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
