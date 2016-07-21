<%-- 
    Document   : ListarExame
    Created on : 14/10/2015, 09:31:15
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <!--META-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Listar Exames-SFS</title>

        <!--STYLESHEETS-->
        <link href="styleCadastro.css" rel="stylesheet" type="text/css" />

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
                    <h1 align="center">Lista de Exames-SFS</h1>
                    <!--END TITLE-->

                    <!--DESCRIPTION-->
                    <span>Para acessar é necessário.</span>
                    <!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="table">
                        <fieldset>

                            <!--Alterar for, id e class-->

                            <label for="inputEmail">Insira o número do SUS do paciente</label> <br>
                            <input id="inputEmail" type="text" name="SUSnumero"  class="input username" /> <br>
                            <input type="submit" name="submit" value="Buscar" class="button"/>        						
                        </fieldset>
                    </div>

                </div>

                <div class="content">

                    <div class="table">
                        <fieldset>
                            <legend>Exames</legend>
                            <table>

                                <colgroup span="4"></colgroup>
                                <tr>
                                    <th >Paciente</th>
                                    <th>Médico Solicitante</th>
                                    <th>Tipo do Exame</th>
                                    <th>Data da Solicitação</th>
                                </tr>

                                <tr>
                                    <td>Marco Augusto</td>                                   
                                    <td>João Marcos</td>
                                    <td>Endoscopia</td>
                                    <td>14/10/2015</td>
                                </tr>

                                <tr>
                                    <td>Marco Augusto</td>
                                    <td>Francisco José</td>
                                    <td>Raio-x</td>
                                    <td>14/10/2015</td>
                                </tr>

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
