<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <form name="formButton" action="<%= request.getContextPath()%>/ControllerSair" method="POST">
                <h1>Cadastro Efetuado com Sucesso!!</h1>
                Agora vocÊ pode efetuar seu logout. é só cicar ----->>>
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

     
    </body>
</html>
