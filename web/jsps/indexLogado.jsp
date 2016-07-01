<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Logado</title>

        <!--STYLESHEETS-->
        <!--        <link href="css/style.css" rel="stylesheet" type="text/css" />-->
        <!--        <link href="jsps/css/style_indexLogado.css" rel="stylesheet" type="text/css" />-->
        <link href="jsps/css/style_indexLogado.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="jsps/css/normalize.css">
        <link rel="stylesheet" href="jsps/css/gallery.prefixed.css">
        <link rel="stylesheet" href="jsps/css/gallery.theme.css">
        <!--SCRIPTS-->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <!--Slider-in icons-->

    </head>
    <body>

        <div class="gallery autoplay items-3">
            <div id="item-1" class="control-operator"></div>
            <div id="item-2" class="control-operator"></div>
            <div id="item-3" class="control-operator"></div>

            <figure class="item">
                <img src="jsps/images/img1.png" alt="imagem 1"/>
            </figure>

            <figure class="item">
                <br/><br/>
                <img src="jsps/images/img2.png" alt="imagem 1"/>
                <img src="jsps/images/img2b.png" alt="imagem 1"/>
            </figure>

            <figure class="item">
               
  <%@page import="servlet.LoginBean"%>  

                <h1>Você está logado!</h1>  
                <%
                    LoginBean bean = (LoginBean) request.getAttribute("bean");
                    out.print("Bem vindo, " + bean.getEmail());
                    out.print("</br>");
                    out.print("Sua sessão está definida pela seguinte ID:" + session.getId());
                %> 
                <br/><br/><br/><br/><br/><br/>
                <img src="jsps/images/img3.png" alt="imagem 1" width="720" height="205"/>
            </figure>

            <div class="controls">
                <a href="#item-1" class="control-button">•</a>
                <a href="#item-2" class="control-button">•</a>
                <a href="#item-3" class="control-button">•</a>
            </div>
        </div>



        <div class="menu">

            <!--            <button class="button">Button</button>-->
            <form name="formButton" action="<%= request.getContextPath()%>/ControladorDeRedirecionamento" method="POST">
                <input type="submit" name="opcao" class="button" value="Home">
                <input type="submit" name="opcao" class="button" value="CadastrarConsulta">
                <input type="submit" name="opcao" class="button" value="CadastrarExame">
                <input type="submit" name="opcao" class="button" value="ListarConsulta">
                <input type="submit" name="opcao" class="button" value="ListarExame">
                <input type="submit" name="opcao" class="button" value="CadastrarPaciente">
                <input type="submit" name="opcao" class="button" value="CadastrarMedico">
                <input type="submit" name="opcao" class="button" value="Sair">
            </form>
        </div>

        <!--        <div id="cssmenu">
                    <ul>
                        <li class='active'><a href='#'>Home</a></li>
                        <li><a href='#'>Consulta</a></li>
                        <form name="acao" action="">
                            <input type="hidden" />
                            <li><a href='#'>Cadastrar Consulta</a></li>
                        </form>
                        <li><a href='#'>Cadastrar Exame</a></li>
                        <li><a href='#'>Listar Exame</a></li>
                        <li><a href='#'>Sair</a></li>
                    </ul>
        
                </div>    Fim class="menu"-->

        <div class="conteudo">
            <div class="conteudo1">

                <img src="jsps/images/im1.jpg" alt="imagem 1"/>
                <h1> Saiba como elaborar um plano alimentar saudável</h1>

            </div> <!--   Fim class="conteudo1"-->

            <div class="conteudo2">
                <img src="jsps/images/im2.png" alt="imagem 1" width="290" height="164"/>
                <h1> Nova doença transmitida pelo Aedes chega ao Brasil</h1>
                A idntificação de três casos de doença provocada por um vírus que jamais circulou no 
                Brasil colocou o Ministério da Saúde em alerta. Sobretudo porque ela é transmitida 
                pelo mosquito Aedes aegypti, o mesmo da dengue. A entrada do vírus da febre Chikungunya 
                no País ocorre num momento em que o número de Aedes é elevado em diversos locais. 
                E em que epidemia de dengue, no Rio e em outras cidades, não está descartada.
                Segundo o ministério, de agosto a novembro três brasileiros - um carioca da Barra e 
                dois moradores de São Paulo - tiveram a febre Chikungunya. Tida do que a dengue - devido 
                à quantidade menor de casos fatais - a Chikungunya se caracteriza por febre alta e 
                dores intensas nas articulações das mãos e pés, que podem se prolongar por até um ano, 
                impossibilitando a pessoa de desenvolver sua rotina.

                "Tivemos três casos importados. Tudo leva a crer que não houve transmissão no País. 
                Todas as medidas de prevenção, como a busca de focos de mosquito nas proximidades 
                das residências dos pacientes, aplicação de fumacê e rastreamento de novos casos foram 
                feitas", afirmou o coordenador do Programa de Controle da Dengue do Ministério da Saúde, 
                Giovanini Coelho.

            </div> <!--   Fim class="conteudo2"-->

        </div> <!--   Fim class="conteudo"-->
    </body>
</html>
