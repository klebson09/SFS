package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorDeRedirecionamento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeRedirecionamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDeRedirecionamento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String home = request.getParameter("home");
//        String cadastrar_consulta = request.getParameter("cadastrar_consulta");
//        String cadastrar_exame = request.getParameter("cadastrar_exame");
//        String listar_consulta = request.getParameter("listar_consulta");
//        String listar_exame = request.getParameter("listar_exame");
//        String sair = request.getParameter("sair");

        String[] values = request.getParameterValues("opcao");
        
        System.out.println(values[0]);

        if (values[0].equals("Home")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsps/indexLogado.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("CadastrarConsulta")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastrarConsulta.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("CadastrarExame")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastrarExame.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("ListarConsulta")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/listarConsulta.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("ListarExame")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/listarExame.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("CadastrarPaciente")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastrarPaciente.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("CadastrarMedico")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/cadastrarMedico.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("TelaLogin")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/login2.jsp");
            rd.forward(request, response);
        }else if(values[0].equals("Sair")){
        RequestDispatcher rd = request.getRequestDispatcher("jsps/indexLogado.jsp");
            rd.forward(request, response);
        }

//       if (home.equals("home")) {
//            RequestDispatcher rd = request.getRequestDispatcher("/'.jsp");
//           rd.forward(request, response);
//       } else if (cadastrar_consulta.equals(
//                "cadastrar_consulta")) {
//            RequestDispatcher rd = request.getRequestDispatcher("/cadastrarConsulta.jsp");
//            rd.forward(request, response);
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("/cadastrarConsulta.jsp");
//            rd.forward(request, response);
//        }

    }

}
