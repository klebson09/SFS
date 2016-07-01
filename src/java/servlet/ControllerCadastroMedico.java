/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAOPessoa;
import model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
//import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Medico;

public class ControllerCadastroMedico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //todo valor que vem do formulario html ou jsp é string e precisa converter para int
        //obs. tipo data, tbm converter
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");//pegando dados de um formulário WEB 
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
//        String telefone = request.getParameter("telefone");
//        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String numCRM = request.getParameter("numCRM");
        String pwd = request.getParameter("pwd");
//        System .out.println("mostra logradouro " +nome+ "complemento:" + dataNasc + "n:" + cpf + "cidade:" + rg + "estado:" + email + "cep:" + pwd + "");

        Medico medico = new Medico();
        medico.setNumCRM(numCRM);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setDataNasc(dataNasc);
        pessoa.setCpf(cpf);
        pessoa.setRg(rg);
        pessoa.setEmail(email);
        pessoa.setPwd(pwd);

        ArrayList<Object> listaObjetos = new ArrayList<>();
        listaObjetos.add(pessoa);
        listaObjetos.add(medico);

        ControladorDAO controladorDao = new ControladorDAO();

        controladorDao.construtorDeObjetos(pessoa, medico, "Medico");
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);

    }
}
