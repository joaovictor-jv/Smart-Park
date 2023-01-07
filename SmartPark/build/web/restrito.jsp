<%-- 
    Document   : restrito
    Created on : 2 de set. de 2022, 10:29:08
    Author     : joao.vmgonso
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="config.css">
        <link rel="stylesheet" type="text/css" href="menu.css">
    </head>
    <body>
        <header>

            <div class="logo"> <img src="logoSmartPark.png"> </div>

            <div class="acesso">

                <%
                    String nomeUsu;
                    nomeUsu = request.getParameter("nome");

                    String celularUsu;
                    celularUsu = request.getParameter("celular");
                %>

                <p>
                    <b>Bem-vindo</b> <font color="white"><%=nomeUsu%> - <%=celularUsu%></font>
                </p>

            </div>

        </header>
        <nav>

            <div class="menu">
                <button class="botao"><a href="abertura.html" target="centro" id="home">Home</a></button>
            </div>
                
            <div class="menu">

                <button class="botao">Usuário</button>
                <div class="submenu">
                    <a href="cadUsu.html" target="centro">Cadastro de Usuário</a>
                    <a href="cadCli.html" target="centro">Cadastro de Cliente</a>
                    <a href="conCli.html" target="centro">Consulta de Cliente</a>
                    <a href="saidaCli.html" target="centro">Saída de Cliente</a>
                    <a href="altCli.jsp" target="centro">Alterar</a>
                    <a href="listCli.html" target="centro">Listagem de Clientes</a>
                    <a href="excUsu.html" target="centro">Exclusão de Usuário</a>
                </div>
            </div>

        </nav>
        <section>

            <iframe src="abertura.html" name="centro"></iframe>

        </section>
        <footer>

        </footer>
    </body>
</html>
