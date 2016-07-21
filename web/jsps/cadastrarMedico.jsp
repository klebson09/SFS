<%-- 
    Document   : cadastrarMedico
    Created on : 14/10/2015, 09:29:56
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
            <form name="cadastro-form" class="cadastro-form" method="POST" action="<%= request.getContextPath()%>/ControllerCadastroMedico">
                <!--HEADER-->
                <div class="header">
                    <!--TITLE--><h1>Cadastrar Médico - SFS</h1><!--END TITLE-->
                    <!--DESCRIPTION--><span>Para acessar é necessário.</span><!--END DESCRIPTION-->
                </div>

                <div class="content">

                    <div class="pessoal">
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <label for="inputNome" >Nome</label> <br>
                            <input id="inputNome" type="text" name="nome"  class="input username" /> <br>
                            <label for="inputDataNasc">Data de Nascimento</label> <br>
                            <input id="inputDataNasc" type="data" name="dataNasc" class="input username" /><br>
                            <label for="sexo" >Sexo</label>
                            <select id="sexo" name=sexo>
                                <option>M</option>
                                <option>F</option>
                            </select><br> <br>
                            <label for="estadoCicvil" >Estado Civil</label>
                            <select id="estadoCivil" name=estadoCivil>
                                <option>Solteiro(a)</option>
                                <option>Casado(a)</option>
                                <option>Divorciado(a)</option>
                                <option>Viúvo(a)</option>
                                <option>Separado(a)</option>
                                <option>Companheiro(a)</option>
                            </select><br><br>
                            <label for="inputCPF">CPF</label> <br>
                            <input id="inputCPF" type="text" name="cpf"  class="input username" /> <br>
                            <label for="inputRG">RG</label> <br>
                            <input id="inputRG" type="text" name="rg" class="input username" /><br>
                            <label for="inputNome" >Naturalidade</label> <br>
                            <input id="inputNome" type="text" name="naturalidade"  class="input username" /> <br>
                            <label for="inputEmail">E-mail</label> <br>
                            <input id="inputEmail" type="text" name="email"  class="input username" /> <br>
                            <label for="inputSUS">Nº CRM</label> <br>
                            <input id="inputSUS" type="text" name="numCRM"  class="input username" /> <br>
                            <label for="inputTelefone">Telefone</label> <br>
                            <input id="inputTelefone" type="text" name="telefone"  class="input username" /> <br>		
                            <label for="inputCelular">Celular</label> <br>
                            <input id="inputCelular" type="text" name="celular" class="input username" /><br>
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
                    <fieldset>
                        <legend>Acesso</legend>
                        <div class="acesso">

                            <label for="inputEmail">Senha</label> 
                            <input id="inputEmail" type="text" name="senha"  class="input username" />
                            <label for="inputSenha">Repetir Senha</label> 
                            <input id="inputSenha" type="text" name="senhaRepetida" class="input username" /><br>
                        </div>   
                    </fieldset>
                    <input type="submit" name="submit" value="Cadastrar" class="button"  />
                    <input type="submit" name="submit" value="Cancelar" class="button"  />
                </div>
            </form>
        </div>

        <!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
    </body>
</html>
