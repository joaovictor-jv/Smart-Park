<%-- 
    Document   : mensagens
    Created on : 2 de set. de 2022, 11:09:21
    Author     : joao.vmgonso
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String mensagem;
            mensagem = (String)request.getAttribute("mensagem");
        %>

        <p>
            <%=mensagem%>
        </p>
    </body>
</html>
