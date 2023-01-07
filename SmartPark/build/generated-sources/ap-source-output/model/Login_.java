package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-24T11:13:28")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> senha;
    public static volatile SingularAttribute<Login, String> usuarioemail;
    public static volatile SingularAttribute<Login, Usuario> usuario;

}