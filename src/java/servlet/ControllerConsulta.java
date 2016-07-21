package servlet;

import controlador.Login.LoginBean;
import dao.DAOConsulta;
import model.Consulta;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Endereco;
import model.Medico;
import model.Paciente;

public class ControllerConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        LoginBean bean= (LoginBean) session.getAttribute("bean");
        
        response.setContentType("text/html;charset=UTF-8");
        String nomeMedico = request.getParameter("medico");
        String tipoConsulta = request.getParameter("tipoConsulta");
        String dataConsulta = request.getParameter("dataConsulta");
        String observacao = request.getParameter("observacao");
        String descricaoConsulta = request.getParameter("descricaoConsulta");
        
        Paciente paciente = new Paciente(bean.getEmail(), bean.getPassword());
        Medico medico  = new Medico();
        medico.setNome(nomeMedico);
        
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(dataConsulta);
        consulta.setTipoConsulta(tipoConsulta);
        consulta.setObservacao(observacao);
        consulta.setDescricaoConsulta(descricaoConsulta);
        
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
        listaObjetos.add(consulta);
        listaObjetos.add(endereco);
        listaObjetos.add(paciente);
        listaObjetos.add(medico);
        
        ControladorDAO controladorDao = new ControladorDAO();
        controladorDao.addObjeto(listaObjetos, "Consulta");
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastroSucesso.jsp");
        rd.forward(request, response);
    }

}
//   ------>>>> SÃO OS DADOS DO ENDEREÇO <<<<-------
//    int numero = Integer.parseInt(request.getParameter("numero"));
//    String complemento = request.getParameter("complemento");
//    String cidade = request.getParameter("cidade");
//    String estado = request.getParameter("estado");
//    String cep = request.getParameter("cep");
//como ele utiliza três objetos (endereço, pessoa e paciente) eu não sei como passar todos os dados para 
//os respectivos objetos
// ERRO SOLUCIONADO era esperado um construtor de set paramentros (como esta especificado na classe pessoa) porem só existia 6 parametros

// System.out.println ( "mostra consulta " +consulta+"complemento:"+complemento+"n:"+numero+"cidade:"+cidade+"estado:"+estado+"cep:"+cep+"");
// Consulta.setIdConsulta(Integer.MIN_VALUE);
//        Consulta Consulta;
//  String IdConsulta = request.getParameter("IdConsulta");
//todo valor que vem do formulario html ou jsp é string e precisa converter para int
//obs. tipo data, tbm converter
// int idConsulta = integer.parseInt(request.getParameter("idConsulta"));
//int pacienteidPaciente = integer.parseInt(request.getParameter("pacienteidPaciente"));
//  int MedicoidMEdico = request.getParameter("MedicoidMEdico");
//static final long serialVersionUID = 1L;
// byte[] arquivoConsulta = request.getParameter("arquivoConsulta");
//converter string para data
//        pessoa.setDataNasc(dataNasc);
