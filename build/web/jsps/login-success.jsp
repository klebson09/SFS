<%@page import="servlet.LoginBean"%>  

<p>Voc� est� logado!</p>  
<%
    LoginBean bean = (LoginBean) request.getAttribute("bean");
    out.print("Bem vindo, " + bean.getName()); out.print("</br>");
    out.print("Sua sess�o est� definida pela seguinte ID:" + session.getId()); 
%>  