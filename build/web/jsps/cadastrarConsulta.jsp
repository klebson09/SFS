<%-- 
    Document   : cadastrarConsulta
    Created on : 14/10/2015, 09:30:19
    Author     : Aluno
--%>
<%@page language="java" contentType="text/html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Medico"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<jsp:useBean id="medicos" class="servlet.ControladorDAO"/>
<%
    // Create an ArrayList with test data
    ArrayList listamedicos = medicos.buscarMedicos();
    session.setAttribute("listaDeMedicos", listamedicos);
%>
<html>
    <head>
        <!--META-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cadastro Form</title>

        <!--STYLESHEETS-->
        <link href="jsps/css/style.css" rel="stylesheet" type="text/css" />

        <!--SCRIPTS-->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <!--Slider-in icons-->
        <script type="text/javascript">
            $(document).ready(function () {
                $(".username").focus(function () {
                    $(".user-icon").css("left", "-48px");
                });
                $(".username").blur(function () {
                    $(".user-icon").css("left", "0px");
                });

                $(".password").focus(function () {
                    $(".pass-icon").css("left", "-48px");
                });
                $(".password").blur(function () {
                    $(".pass-icon").css("left", "0px");
                });
            });
        </script>
    </head>
    <body>
        <div>
            <h1>  <br/>  </h1>
            <form name="cadastro-form" class="cadastro-form" method="POST" action="<%= request.getContextPath()%>/ControllerConsulta">
                <!--HEADER-->
                <div class="header">
                    <!--TITLE--><h1>Consulta  - SFS</h1><!--END TITLE-->
                    <!--DESCRIPTION--><span>Para acessar é necessário.</span><!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="pessoal">
                        <fieldset>
                            <legend>Dados da Consulta</legend>
                            Tipo Consulta
                            <select name=tipoConsulta>
                                <option>Clinico Geral</option>
                                <option>Coloproctologista</option>
                                <option>Nutricionista</option>
                                <option>Traumatologia</option>
                            </select><br> <br>
                            Escolha o Médico:<br>
                            <c:forEach var="medico" items="${medicos.buscarMedicos()}"> 
                                    <td><c:out value="${medico.nome}" /></td>
                                </c:forEach><br>
                            
                            <label for="inputMedico">Escreva o nome do medico</label> <br>
                            <input id="inputMedico" type="text" name="medico"/><br>
                            
                            <label for="inputDataConsulta">Data da Consulta</label> <br>
                            <input id="inputDataConsulta" type="text" name="dataConsulta"/><br>
                            
                            <label for="descricaoConsulta">Descricao da Consulta</label> <br>
                            <textarea rows="4" cols="50" name="descricaoConsulta"> </textarea><br>
                            Observação
                            <textarea rows="4" cols="50" name="observacao">	
                            </textarea>  <br>
                            Selecionar Arquivo <br>
                            <input id="inputArq" type="file" name="arquivo_consulta" class="" /><br>

                        </fieldset>
                    </div>
                    <div class="endereco">
                        <fieldset>
                            <legend>Endereço</legend>
                            <label for="inputCep">CEP</label> <br>
                            <input id="inputCep" type="text" name="CEP" class="input username" /><br>
                            <label for="inputRua">Rua</label> <BR>
                            <input id="inputRua" type="text" name="logradouro"  class="input username" /> <br>
                            <label for="inputNumero">Número</label> <br>
                            <input id="inputNumero" type="text" name="numero" class="input username" /><br>
                            <label for="inputComplemento">Complemento</label> <BR>
                            <input id="inputComplemento" type="text" name="complemento"  class="input username" /> <br>
                            <label for="inputBairro">Bairro</label> <BR>
                            <input id="inputBairro" type="text" name="bairro"  class="input username" /> <br>
                            <label for="inputCidade">Cidade</label> <br>
                            <input id="inputCidade" type="text" name="cidade" class="input username" /><br>
                            <label for="estadosSelect">Estado</label> <BR>
                            <select id="estadosSelect" name=estado>
                                <option>AC</option>
                                <option>AL</option>
                                <option>AP</option>
                                <option>AM</option>
                                <option>BA</option>
                                <option>CE</option>
                                <option>DF</option>
                                <option>ES</option>
                                <option>GO</option>
                                <option>MA</option>
                                <option>MT</option>
                                <option>MS</option>
                                <option>MG</option>
                                <option>PA</option>
                                <option>PB</option>
                                <option>PR</option>
                                <option>PE</option>
                                <option>PI</option>
                                <option>RJ</option>
                                <option>RN</option>
                                <option>RS</option>
                                <option>RO</option>
                                <option>RR</option>
                                <option>SC</option>
                                <option>SP</option>
                                <option>SE</option>
                                <option>TO</option>
                            </select><br><br>
                        </fieldset> 
                    </div>

                </div>

                <div class="footer">
                    <!--<input type="hidden" name="tarefa" value="cadastrar"/>
                    <button type="submit">Cadastrar</button> -->

                    <input type="submit" name="submit" value="Inserir" class="button"  />
                    <input type="submit" name="submit" value="Cancelar" class="register"  />
                </div>
            </form>
        </div>




        <!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
    </body>
</html>
