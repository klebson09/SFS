/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Medico;

public class ControllerCadastroExame extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //todo valor que vem do formulario html ou jsp é string e precisa converter para int
        //obs. tipo data, tbm converter
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");
        String sexo = request.getParameter("sexo");
        String CPF = request.getParameter("cpf");
        
        
        ControladorDAO controladorDao = new ControladorDAO();
        
        ArrayList<Object> listaObjetos = new ArrayList<>();
        
        
        controladorDao.addObjeto(listaObjetos, "Medico");
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);

    }
}
