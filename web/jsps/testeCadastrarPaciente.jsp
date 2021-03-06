<%-- 
    Document   : cadastrarPaciente
    Created on : 14/10/2015, 09:29:43
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Paciente</title>

        <!--STYLESHEETS-->
<!--        <link href="css/style.css" rel="stylesheet" type="text/css" />-->
        <link href="jsps/css/style.css" rel="stylesheet" type="text/css" />
        <!--SCRIPTS-->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <!--Slider-in icons-->
        <script type="text/javascript">
            $(document).ready(function() {
                $(".username").focus(function() {
                    $(".user-icon").css("left", "-48px");
                });
                $(".username").blur(function() {
                    $(".user-icon").css("left", "0px");
                });

                $(".password").focus(function() {
                    $(".pass-icon").css("left", "-48px");
                });
                $(".password").blur(function() {
                    $(".pass-icon").css("left", "0px");
                });
            });
        </script>
    </head>
    <body>

        <div>
            
            <h1>  <br/>  </h1>
            <form name="cadastro-form" class="cadastro-form" method="POST" action="<%= request.getContextPath() %>/ControllerCadastroPaciente">
<!--            <form name="cadastro-form" class="cadastro-form" method="POST" action="<%= request.getContextPath() %>/ControllerCadastroPaciente">-->
                <!--HEADER-->
                <div class="header">
                    <!--TITLE--><h1>Cadastrar Paciente - SFS</h1><!--END TITLE-->
                    <!--DESCRIPTION--><span>Para acessar é necessário.</span><!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="pessoal">
<!--                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <label for="inputNome" >Nome</label> <br>
                            <input id="inputNome" type="text" name="nome"  class="input username" /> <br>
                            <label for="inputDataNasc">Data de Nascimento</label> <br>
                            <input id="inputDataNasc" type="data" name="dataNasc" class="input username" /><br>
                                                        Sexo
                                                        <select name=sexo>
                                                            <option>Masculino</option>
                                                            <option>Feminino</option>
                                                        </select><br> <br>
                                                        Estado Civil
                                                        <select name=estadoCivil>
                                                            <option>Solteiro</option>
                                                            <option>Casado</option>
                                                        </select><br><br>
                                                        <label for="inputNome" >Naturalidade</label> <br>
                                                        <input id="inputNome" type="text" name="naturalidade"  class="input username" /> <br>
                            <label for="inputRG">RG</label> <br>
                            <input id="inputRG" type="text" name="rg" class="input username" /><br>
                            <label for="inputCPF">CPF</label> <br>
                            <input id="inputCPF" type="text" name="cpf"  class="input username" /> <br>
                                                        <label for="inputRG">Nº SUS</label> <br>
                                                        <input id="inputRG" type="text" name="sus" class="input username" /><br>
                                                        <label for="inputCPF">Telefone</label> <br>
                                                        <input id="inputCPF" type="text" name="telefone"  class="input username" /> <br>		
                                                        <label for="inputRG">Celular</label> <br>
                                                        <input id="inputRG" type="text" name="celular" class="input username" /><br>
                            <label for="inputCPF">E-mail</label> <br>
                            <input id="inputCPF" type="text" name="email"  class="input username" /> <br>
                            <label for="inputSUS">Número do SUS</label> <br>
                            <input id="inputSUS" type="text" name="inputSUS"  class="input username" /> <br>
                        </fieldset>
                    </div>
                    OBS. FALTA INSERIR NA TABELA DO BANCO DE DADOS TELEFONE, Celular E Genero
                    
                                        <div class="endereco">
                                            <fieldset>
                                                <legend>Endereço</legend>
                                                <label for="inputRua">Rua</label> <BR>
                                                <input id="inputRua" type="text" name="logradouro"  class="input username" /> <br>
                                                <label for="inputRua">Complemento</label> <BR>
                                                <input id="inputRua" type="text" name="complemento"  class="input username" /> <br>
                                                <label for="inputNumero">Número</label> <br>
                                                <input id="inputNumero" type="text" name="numero" class="input username" /><br>
                                                <label for="inputBairro">Bairro</label> <BR>
                                                <input id="inputBairro" type="text" name="bairro"  class="input username" /> <br>
                                                <label for="inputCidade">Cidade</label> <br>
                                                <input id="inputCidade" type="text" name="cidade" class="input username" /><br>
                                                <label for="inputEstado">Estado</label> <BR>
                                                <input id="inputEstado" type="text" name="estado"  class="input username" /> <br>
                                                <label for="inputCep">CEP</label> <br>
                                                <input id="inputCep" type="text" name="cep" class="input username" /><br>
                                            </fieldset> 
                                        </div>
                    <fieldset>-->
                        <legend>Dados da tabela paciente</legend>
                        <div class="acesso">

                            <label for="inputNumSUS">Número do SUS</label> 
                            <input id="inputNumSUS" type="text" name="NumSUS"  class="input username" /> 
                            <label for="inputPessoa_idPessoa">Fk SUS Pessoa_idPessoa</label> 
                            <input id="inputPessoa_idPessoa" type="text" name="Pessoa_idPessoa"  class="input username" /> 
                            <!--                            <label for="inputSenha">Repetir Senha</label> 
                                                        <input id="inputSenha" type="text" name="repetirSenha" class="input username" /><br>-->

                        </div>
                    </fieldset>
                    <input type="submit" name="submit" value="Cadastrar" class="button"  />
                    <input type="submit" name="submit" value="Cancelar" class="register"  />
                </div>
        </div>

        <div class="footer">
            <!--<input type="hidden" name="tarefa" value="cadastrar"/>
            <button type="submit">Cadastrar</button> -->
            <!--
                                <input type="submit" name="submit" value="Cadastrar" class="button"  />
                                <input type="submit" name="submit" value="Cancelar" class="register"  />-->
        </div>
    </form>
</div>
<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
</body>
</html>
