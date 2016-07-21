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
import model.Exame;
import model.Consulta;

public class ControllerCadastroExame extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String descricaoConsulta = request.getParameter("descricaoConsulta");
        String tipoExame = request.getParameter("tipoExame");
        String especialidade = request.getParameter("especialidade");
        String observacao = request.getParameter("observacao");
        String dataExame = request.getParameter("dataExame");
        
        Exame exame = new Exame(tipoExame, especialidade, observacao, dataExame);
        
        Consulta consulta = new Consulta();
        consulta.setDescricaoConsulta(descricaoConsulta);
        
        ControladorDAO controladorDao = new ControladorDAO();
        ArrayList<Object> listaObjetos = new ArrayList<>();
        
        listaObjetos.add(exame);
        listaObjetos.add(consulta);
        
        controladorDao.addObjeto(listaObjetos, "Exame");
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);

    }
}
