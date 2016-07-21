<%-- 
    Document   : listarConsulta
    Created on : 14/10/2015, 09:30:56
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


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
                            <legend>Dados da Consulta</legend>
                            Tipo Consulta
                            <select name=tipo_consulta>
                                <option>Clinico Geral</option>
                                <option>Coloproctologista</option>
                                <option>Nutricionista</option>
                                <option>Traumatologia</option>
                            </select><br> <br>
                            Médico
                            <select name=medico>
                                <option>João Marcos</option>
                                <option>Francisco José</option>
                                <option>Mary Jane</option>
                                <option>Leonardo Gonçalves</option>
                            </select><br> <br>

                        </fieldset>
                    </div>

                </div>

                <div class="content">

                    <div class="table">
                        <fieldset>
                            <legend>Consultas</legend>
                            <table>

                                <colgroup span="4"></colgroup>
                                <tr>
                                    <th>Médico Responsável</th>
                                    <th >Paciente</th>
                                    <th>Data da Consulta</th>
                                    <th>Local</th>
                                </tr>

                                <tr>
                                    <td>João Marcos</td>
                                    <td>Marco Augusto</td>
                                    <td>14/10/2015 </td>
                                    <td>Hospital Barão de Lucena</td>
                                </tr>

                                <tr>
                                    <td>João Marcos</td>
                                    <td>Lucas Andrade</td>
                                    <td>30/10/2015</td>
                                    <td>Hospital da Restauração</td>
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
