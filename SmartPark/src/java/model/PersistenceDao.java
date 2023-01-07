
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class PersistenceDao {
    
    private EntityManagerFactory conn;
    private EntityManager manager;
    private Login dadosLoginUsuario;
    //private Login Usuariocargo;
    
    public void conectar() {
        conn = Persistence.createEntityManagerFactory("SmartParkPU");
        manager = conn.createEntityManager();
    }
    
    public Login verificarLogin(Login log) {
        conectar();
        try {
            dadosLoginUsuario = manager.find(Login.class, log.getUsuarioemail());
            return dadosLoginUsuario;
        } catch (Exception ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    
    public void desconectar() {
        manager.close();
        conn.close();
    }
    
    public Login validarUsuario(String email, String senha) {
        conectar();
        try {
            TypedQuery<Login> query = manager.createNamedQuery("Login.findByEmailSenha", Login.class);
            query.setParameter("email",email);
            query.setParameter("senha",senha);
            Login usuario = query.getSingleResult();
            return usuario;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }
    
    public int salvarUsuario(Usuario usu) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(usu);
            manager.getTransaction().commit();
            return 1;
        } catch (EntityExistsException | RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            desconectar();
        }
    }
    
    public int excluirUsuario(String nomeUsu) {
        conectar();
        try {
            //Localiza o departamento que queremos excluir
            Usuario usuario = new Usuario();
            usuario = manager.find(Usuario.class, nomeUsu);
            //Exclui o departamento localizado
            manager.getTransaction().begin();
            manager.remove(usuario);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            return 2;
        } finally {
            desconectar();
        }
    }
    
    public int cadastrarCliente(Cliente cli) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(cli);
            manager.getTransaction().commit();
            return 1;
        } catch (EntityExistsException | RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            desconectar();
        }
    }
    
    public static void dataHora(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(dtf.format(LocalDateTime.now()));
    }
    
    public int entradaSaida(Date entrada, Date saida) {
        conectar();
        Cliente cli = new Cliente();
        cli.setEntradaCliente(entrada);
        cli.setSaidaCliente(saida);

        try {
            manager.getTransaction().begin();
            manager.merge(cli);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            desconectar();
        }
    }
    
    public List<Cliente> consultarCliente(String p) {
        conectar();
        try {
            TypedQuery<Cliente> query = manager.createNamedQuery("Cliente.findByPlacaCliente", Cliente.class);
            query.setParameter("placaCliente", p);
            List<Cliente> clientes = query.getResultList();
            return clientes;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }
    
    public Cliente consultarPlaca(String p) {
        conectar();
        try {
            TypedQuery<Cliente> query = manager.createNamedQuery("Cliente.findByPlacaCliente", Cliente.class);
            query.setParameter("placaCliente", p);
            Cliente cliente = query.getSingleResult();
            return cliente;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }    
    
    
    public List<Cliente> listarCliente(String placaCliente) {
        conectar();
        try {
            TypedQuery<Cliente> query = manager.createNamedQuery("Cliente.findAll", Cliente.class);
            List<Cliente> clientes = query.getResultList();
            return clientes;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }
    
    /*
    hhtps://github.com/JodaOrg/joda-time/releases

PrintWriter out = response.getWriter();

String d1 = request.getParameter("data1");
String d2 = request.getParameter("data2");

DateTimeFormatter dformat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
DateTime horasData1 = DateTime.parse(d1, dformat);
DateTime horasData2 = DateTime.parse(d2, dformat);

int hours = Hours.hoursBetween(horasData1, horasData2).getHours();
out.print(hours);
    */
    
}