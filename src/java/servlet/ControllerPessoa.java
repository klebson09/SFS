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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

public class ControllerPessoa extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        //todo valor que vem do formulario html ou jsp é string e precisa converter para int
        //obs. tipo data, tbm converter
        
// FALTA VERIFICAR A CONVERSÃO DA VARIAVEL dataNasc para o tipo Date        
        String dataNasc = request.getParameter("dataNasc");//pegando dados de um formulário WEB 
        //SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras 
        //Date dataNasc = sdf1.parse(dataNasc);

        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        System .out.println("mostra nome: " +nome+ "  dat nascimento: :" + dataNasc + "  CPF: " + cpf + "  Rg: " + rg + "  EMAIL: " + email + "  SENHA: " + pwd + "  ");
//        System .out.println("mostra logradouro " +nome+ "complemento:" + dataNasc + "n:" + cpf + "cidade:" + rg + "estado:" + email + "cep:" + pwd + "");
        Pessoa pessoa = new Paciente();
        // pessoa.setIdPessoa(Integer.MIN_VALUE);
        //converter string para data
//        pessoa.setDataNasc(dataNasc);
        pessoa.setNome(nome);
        pessoa.setDataNasc(dataNasc);
        pessoa.setCpf(cpf);
        pessoa.setRg(rg);
        pessoa.setEmail(email);
        pessoa.setPwd(pwd);

        DAOPessoa daopessoa = new DAOPessoa();
        daopessoa.adicionar(pessoa);

    }
}
