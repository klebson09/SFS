<%-- 
    Document   : login
    Created on : 14/10/2015, 09:28:49
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <!--META-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="jsps/css/style_2.css" rel="stylesheet" type="text/css" />

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

        <!--WRAPPER-->
        <div id="wrapper">

            </div>
            <!--END WRAPPER-->

            <!--GRADIENT--><div class="gradient">
                <img src="jsps/images/500.png" WIDTH="600" HEIGHT="500"></img>   
                <h1>Error de servidor</h1>
            </div><!--END GRADIENT-->

    </body>
</html>