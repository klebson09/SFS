<%-- 
    Document   : cadastrarExame
    Created on : 14/10/2015, 09:30:33
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>



        <!--META-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cadastro Exame</title>

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
            <form name="cadastro-form" class="cadastro-form"method="POST" action="<%= request.getContextPath()%>/ControllerCadastroMedico">
                <!--HEADER-->
                <div class="header">
                    <!--TITLE--><h1>Cadastrar Exame - SFS</h1><!--END TITLE-->
                    <!--DESCRIPTION--><span></span><!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="pessoal">
                        <fieldset>
                            <legend>Exames</legend>
                            <label for="inputTipoExame" >Tipo do Exame</label> <br>
                            <input id="inputTipoExame" type="text" name="tipoExame"  class="input username" /> <br>
                            <label for="inputEspecialidade">Especialidade</label> <br>
                            <input id="inputEspecialidade" type="data" name="especialidade" class="input username" /><br>
                            <label for="inputObservacao" >Observação</label> <br>
                            <input id="inputObservacao" type="text" maxlength="55" name="observacao"  class="input username" /> <br>
                            <label for="inputDataDoExame">Data do Exame</label> <br>
                            <input id="inputDataDoExame" type="text" name="dataExame" class="input username" /><br>

                        </fieldset>
                    </div>


                </div>




                <div class="footer">
                    <!--<input type="hidden" name="tarefa" value="cadastrar"/>
                    <button type="submit">Cadastrar</button> -->

                    <input type="submit" name="submit" value="Cadastrar" class="button"  />
                    <input type="submit" name="submit" value="Cancelar" class="register"  />
                </div>
            </form>
        </div>




        <!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
    </body>
</html>
