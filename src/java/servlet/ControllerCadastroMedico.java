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
import model.Paciente;
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
        Pessoa pessoa = new Paciente();
        // pessoa.setIdPessoa(Integer.MIN_VALUE);
        //converter string para data
//        pessoa.setDataNasc(dataNasc);

        Medico medico = new Medico();
        medico.setNumCRM(numCRM);

        medico.setNome(nome);
        medico.setDataNasc(dataNasc);
        medico.setCpf(cpf);
        medico.setRg(rg);
        medico.setEmail(email);
        medico.setPwd(pwd);

        ArrayList<Object> listaObjetos = new ArrayList<>();
        listaObjetos.add(medico);
        listaObjetos.add(medico);

        ControladorDAO controladorDao = new ControladorDAO();

        controladorDao.construtorDeObjetos(listaObjetos, "Medico");
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);

    }
}
