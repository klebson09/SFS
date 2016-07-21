<%-- 
    Document   : listarConsulta
    Created on : 14/10/2015, 09:30:56
    Author     : Aluno
--%>

<%@page import="controlador.Login.LoginBean"%>
<%@page language="java" contentType="text/html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:useBean id="controladorDAO" class="servlet.ControladorDAO"/>
<%
    LoginBean bean= (LoginBean) session.getAttribute("bean");
    String emailPaciente = bean.getEmail();
    String senhaPaciente = bean.getPassword();
%>
<html>
    <head>
        <!--META-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="css/style.css" rel="stylesheet" type="text/css" />

        <title>Listar Consultas-SFS</title>

        <!--STYLESHEETS-->


        <!--SCRIPTS-->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <!--Slider-in icons-->

    </head>
    <body>

        <div>
            <h1>  <br/>  </h1>
            <form name="cadastro-form" class="cadastro-form"method="POST" action="CadastroServlet">
                <!--HEADER-->
                <div class="header">
                    <!--TITLE-->
                    <h1 align="center">Lista de Médicos-SFS</h1>
                    <!--END TITLE-->

                    <!--DESCRIPTION-->
                    <span>Para acessar é necessário.</span>
                    <!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="table">
                        <fieldset>
                            <legend>Consultas</legend>
                            <table>

                                <colgroup span="4"></colgroup>
                                <tr>
                                    <th>Numero CRM Medico</th>
                                    <th>Data da Consulta</th>
                                    <th>Tipo da Consulta</th>
                                    <th>Descricao da Consulta</th>
                                </tr>
                                
                                <c:forEach var="consulta" items="${controladorDAO.buscarConsultasPaciente(bean.getEmail(), bean.getPassword())}"> 
                                    <tr>
                                        <td><c:out value="${consulta.medicoCRM}" /></td>
                                        <td><c:out value="${consulta.dataConsulta}" /></td>
                                        <td><c:out value="${consulta.tipoConsulta}" /></td>
                                        <td><c:out value="${consulta.descricaoConsulta}" /></td>
          
                                </c:forEach><br>
                                

                            </table>

                        </fieldset>
                    </div>

                </div>


                <div class="footer">
                    <!--<input type="hidden" name="tarefa" value="cadastrar"/>
                    <button type="submit">Cadastrar</button> -->
                    <img class="imagem-wrap" src="logo_portal.jpg" alt="Tim Berners-Lee" width="500" height="50" />

                </div>
            </form>
        </div>




        <!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
    </body>
</html>
