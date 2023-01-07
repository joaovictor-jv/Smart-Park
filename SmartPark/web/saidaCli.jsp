<%@page import="model.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Saída de Cliente</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="botoes.css">
    </head>
    <body>
        <%

            Cliente cliente = (Cliente) request.getAttribute("cliente");

        %>    


        <form method="post" action="Controle">
            <input type="hidden" name="flag" value="saidaCli">
            <p>
                <label for="placaCliente">Placa de Cliente:</label>
                <input type="text" size="45" maxlength="45" name="placaCliente" value="<%= cliente.getPlacaCliente() %>" id="placaCliente" required>
            </p>
            <p>
                <label for="dataEntrada">Data de Entrada:</label>
                <input type="text" size="45" maxlength="45" name="dataEntrada" value="<%= cliente.getEntradaCliente() %>" id="dataEntrada">
            </p>
            <p>
                <label for="saida">Saída:</label>
                <input type="datetime-local" size="45" maxlength="45" name="saidaCliente" id="saidaCliente" required>
            </p>
            <p>
                <input type="submit" value="Salvar" id="botaoSalvar">
            </p>

        </form>

    </body>
</html>
