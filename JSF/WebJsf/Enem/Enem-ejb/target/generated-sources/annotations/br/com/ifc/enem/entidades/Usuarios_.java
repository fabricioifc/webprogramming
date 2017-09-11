package br.com.ifc.enem.entidades;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-14T19:43:40")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> senha;
    public static volatile SingularAttribute<Usuarios, BigInteger> cpf;
    public static volatile SingularAttribute<Usuarios, String> nome;
    public static volatile SingularAttribute<Usuarios, Long> id;
    public static volatile SingularAttribute<Usuarios, String> email;

}