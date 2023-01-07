<%@page import="model.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <%
            Cliente cliente = (Cliente) request.getAttribute("cliente");
        %>
        
        <form method="post" action="Controle">
            <input type="hidden" name="flag" value="alterarCli">
            <p>
                <label for="placaCliente">Placa do Cliente:</label>
                <input type="text" size="45" maxlength="45" name="placaCliente" id="placaCliente" value="<%=cliente.getPlacaCliente()%>" readonly>
            </p>
            <p>
                <label for="saida">Entrada:</label>
                <input type="datetime-local" size="45" maxlength="45" name="saidaCliente" id="saidaCliente">
            </p>
            <p>
                <input type="submit" value="Salvar alterações">
            </p>

        </form>

    </body>
</html>