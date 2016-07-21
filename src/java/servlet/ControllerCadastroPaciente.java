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
import model.Endereco;
import model.Paciente;

/**
 *
 * @author klebsonsantana
 */
public class ControllerCadastroPaciente extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");
        String sexo = request.getParameter("sexo");
        String CPF = request.getParameter("cpf");
        String RG = request.getParameter("rg");
        String naturalidade = request.getParameter("naturalidade");
        String estadoCivil = request.getParameter("estadoCivil");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String pwd = request.getParameter("pwd");
        String numSUS = request.getParameter("numSUS");
        
        Paciente paciente = new Paciente(numSUS, nome, dataNasc, sexo, CPF, RG,
                naturalidade, estadoCivil, email, telefone, celular, pwd);
        
        String CEP = request.getParameter("CEP");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        
        Endereco endereco = new Endereco(logradouro, Integer.parseInt(numero), 
                complemento, bairro, cidade, estado, CEP);
        
        ArrayList<Object> listaObjetos = new ArrayList<>();
        listaObjetos.add(paciente);        
        listaObjetos.add(endereco);
        
        ControladorDAO controladorDao = new ControladorDAO();
        
        controladorDao.addObjeto(listaObjetos, "Paciente");
        RequestDispatcher rd = request.
                getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);
    }
}
