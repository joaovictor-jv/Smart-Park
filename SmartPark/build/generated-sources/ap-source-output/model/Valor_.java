package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-24T11:13:28")
@StaticMetamodel(Valor.class)
public class Valor_ { 

    public static volatile ListAttribute<Valor, Cliente> clienteList;
    public static volatile SingularAttribute<Valor, String> categoriaValor;
    public static volatile SingularAttribute<Valor, String> valorHora;
    public static volatile SingularAttribute<Valor, String> valorAdicional;

}