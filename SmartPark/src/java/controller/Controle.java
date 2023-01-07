package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Login;
import model.PersistenceDao;
import model.Usuario;

@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario, senha, flag, placaCliente;
        Date entradaCliente, saidaCliente, permanenciaCliente, dataEntrada = null, dataSaida = null;
        String mensagem;
        int retorno;
        PersistenceDao dao;
        Login dadosLoginUsuario;
        Cliente cli;
        String emailUsu, nomeUsuario, celularUsu, nomeUsu, senhaUsu;
        Usuario usu;

        flag = request.getParameter("flag");
        if (flag.equalsIgnoreCase("login")) {

            usuario = request.getParameter("user");
            senha = request.getParameter("senha");

            Login log = new Login();
            log.setUsuarioemail(usuario);
            log.setSenha(senha);

            dao = new PersistenceDao();
            dadosLoginUsuario = dao.validarUsuario(usuario, senha);

            if (dadosLoginUsuario == null) {
                mensagem = "Usuário e/ou senhas inválidos";
                //response.sendRedirect("mensagens.jsp?mensagem=" + mensagem);
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                nomeUsuario = dadosLoginUsuario.getUsuario().getNomeUsuario();
                celularUsu = dadosLoginUsuario.getUsuario().getCelularUsuario();
                response.sendRedirect("restrito.jsp?nome=" + nomeUsuario + "&celular=" + celularUsu);
            }
        } else if (flag.equalsIgnoreCase("cadUsu")) {
            //Aqui a parte de cadastro de Usuário
            nomeUsu = request.getParameter("nomeUsu");
            emailUsu = request.getParameter("emailUsu");
            celularUsu = request.getParameter("celularUsu");
            senha = request.getParameter("senha");
            usuario = request.getParameter("user");

            Login log = new Login();
            log.setUsuarioemail(usuario);
            log.setSenha(senha);

            usu = new Usuario();
            usu.setNomeUsuario(nomeUsu);
            usu.setEmailUsuario(emailUsu);
            usu.setCelularUsuario(celularUsu);

            dao = new PersistenceDao();
            retorno = dao.salvarUsuario(usu);
            switch (retorno) {
                case 1:
                    mensagem = "Usuário " + nomeUsu + " cadastrado com sucesso";
                    break;
                case 2:
                    mensagem = "Usuário já cadastrado";
                    break;
                default:
                    mensagem = "Erro: contate o administrador";
                    break;
            }
            //response.sendRedirect("mensagens.jsp?mensagem=" + mensagem);
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("cadCli")) {
            //Recebe dados digitados no formulário de cadastro de funcionário
            String dRecebida = request.getParameter("entradaCliente");
            placaCliente = request.getParameter("placaCliente");
            SimpleDateFormat formata = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);

            try {
                dataEntrada = formata.parse(request.getParameter("entradaCliente"));

                //Date dataSaida = formata.parse(request.getParameter("entradaCliente"));
                String a = "";
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
            try {
                //Date dataFormatada2 = formata.parse(request.getParameter("saidaCliente"));
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
            //COLOCAR PERMANENCIA

            //Encapsular os dados recebidos em um objeto da classe Cliente
            cli = new Cliente();
            cli.setPlacaCliente(placaCliente);
            cli.setEntradaCliente(dataEntrada);

            //Chamar o método cadastrarCliente da classe PersistenceDao
            dao = new PersistenceDao();
            retorno = dao.cadastrarCliente(cli);
            if (retorno == 1) {
                mensagem = placaCliente + " salvo com sucesso";
            } else if (retorno == 2) {
                mensagem = "Esta placa já foi cadastrada";
            } else {
                mensagem = "Erro: Entre em contato com o admin";
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("excluirUsuario")) {
            //Aqui a exclusão
            emailUsu = request.getParameter("emailUsu");
            dao = new PersistenceDao();
            retorno = dao.excluirUsuario(emailUsu);
            if (retorno == 1) {
                mensagem = "Usuário " + emailUsu + " excluido com sucesso";
            } else {
                mensagem = "Erro ao tentar excluir o usuário " + emailUsu;
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("consultarCliente")) {
            //Aqui a consulta
            placaCliente = request.getParameter("placaCliente");
            dao = new PersistenceDao();
            List<Cliente> cliente = dao.consultarCliente(placaCliente);
            if (cliente == null) {
                mensagem = "Esta placa não foi encontrada";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("clientes", cliente);
                RequestDispatcher disp = request.getRequestDispatcher("consultaCli.jsp");
                disp.forward(request, response);
            }
        } else if (flag.equalsIgnoreCase("listarCliente")) {
            //Aqui a consulta
            placaCliente = request.getParameter("placaCliente");
            dao = new PersistenceDao();
            List<Cliente> cliente = dao.consultarCliente(placaCliente);
            if (cliente == null) {
                mensagem = "Esta placa não foi encontrada";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("clientes", cliente);
                RequestDispatcher disp = request.getRequestDispatcher("listagemCli.jsp");
                disp.forward(request, response);
            }
        } else if (flag.equalsIgnoreCase("alterarCli")) {
            placaCliente = request.getParameter("placaCliente");
            dao = new PersistenceDao();
            List<Cliente> cliente = dao.consultarCliente(placaCliente);
            if (cliente == null) {
                mensagem = "Esta placa não existe";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("cliente", cliente);
                RequestDispatcher disp = request.getRequestDispatcher("alteraCli.jsp");
                disp.forward(request, response);
            }

        } else if (flag.equalsIgnoreCase("saidaCli")) {
            placaCliente = request.getParameter("placaCliente");
            dao = new PersistenceDao();
            Cliente cliente = dao.consultarPlaca(placaCliente);
            request.setAttribute("cliente", cliente);
            RequestDispatcher disp = request.getRequestDispatcher("saidaCli.jsp");
            disp.forward(request, response);
        }

        /*else if (flag.equalsIgnoreCase("permanencia")) {
            out = response.getWriter();

            String dataEnt = request.getParameter("entradaCliente");
            String dataSai = request.getParameter("saidaCliente");

            DateTimeFormatter dformat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
            DateTime horasData1 = DateTime.parse(dataEnt, dformat);
            DateTime horasData2 = DateTime.parse(dataSai, dformat);

            int hours = Hours.hoursBetween(horasData1, horasData2).getHours();
            out.print(hours);
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
