package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Login;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-24T11:13:28")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Cliente> clienteList;
    public static volatile SingularAttribute<Usuario, String> nomeUsuario;
    public static volatile SingularAttribute<Usuario, String> celularUsuario;
    public static volatile SingularAttribute<Usuario, String> emailUsuario;
    public static volatile SingularAttribute<Usuario, Login> login;

}