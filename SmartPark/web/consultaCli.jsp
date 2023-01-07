<%-- 
    Document   : listagemDeps
    Created on : 23 de set. de 2022, 10:34:30
    Author     : joao.vmgonso
--%>

<%@page import="model.Cliente"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de clientes</title>
        <link rel="stylesheet" type="text/css" href="lista.css">
    </head>
    <body>
        <%
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
        %>
        
        <table border="2px" id="tabela">
            <tr>
                <th>Placa</th>
                <th>Horário de Entrada</th>
                <th>Saída</th>
            </tr>
            <%
               for(Cliente cliente: clientes){
            %>
            
            <tr>
                <td> <%= cliente.getPlacaCliente() %> </td>
                <td> <%= cliente.getEntradaCliente() %> </td>
                <%String placaCliente = URLEncoder.encode(cliente.getPlacaCliente(), "UTF-8");%>
                <td> <a href="Controle?flag=saidaCli&placaCliente=<%= cliente.getPlacaCliente() %>">Saída</a> </td>
            </tr>
            
            <%
                }  
            %>
        </table>
        
    </body>
</html>
