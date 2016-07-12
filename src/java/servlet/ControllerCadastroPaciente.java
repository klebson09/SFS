package servlet;

import dao.DAOPaciente;
import dao.DAOPessoa;
import model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

/**
 *OBS NÃO ESTÁ CADASTRANDO EM 2 TABELAS (ENDERECO E PESSOA)
 * @author klebsonsantana
 */
public class ControllerCadastroPaciente extends HttpServlet {

    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");//pegando dados de um formulário WEB 
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String numSUS = request.getParameter("numSUS");
        String pwd = request.getParameter("pwd");
        
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNasc(dataNasc);
        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setEmail(email);
        paciente.setPwd(pwd);
        paciente.setNumSUS(numSUS);

        ArrayList<Object> listaObjetos = new ArrayList<>();
        listaObjetos.add(paciente);        
        
        ControladorDAO controladorDao = new ControladorDAO();
        
        controladorDao.construtorDeObjetos(listaObjetos, "Paciente");
        RequestDispatcher rd = request.
                getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);
    }
}
