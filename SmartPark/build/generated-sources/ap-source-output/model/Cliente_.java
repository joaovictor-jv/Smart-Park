package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Usuario;
import model.Valor;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-24T11:13:28")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Usuario> usuarioemail;
    public static volatile SingularAttribute<Cliente, String> placaCliente;
    public static volatile SingularAttribute<Cliente, Date> saidaCliente;
    public static volatile SingularAttribute<Cliente, Date> entradaCliente;
    public static volatile SingularAttribute<Cliente, Valor> valorcategoriaValor;
    public static volatile SingularAttribute<Cliente, Double> permanenciaCliente;

}