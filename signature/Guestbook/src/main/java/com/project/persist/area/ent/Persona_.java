package com.project.persist.area.ent;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Persona.class)
public class Persona_ {

    public static volatile SingularAttribute<Country,Integer> id;
    public static volatile SingularAttribute<Country,String> apellido;
    public static volatile SingularAttribute<Country,String> direccion;
    public static volatile SingularAttribute<Country,String> nombre;
    public static volatile SingularAttribute<Country,Integer> paisId;
    public static volatile SingularAttribute<Country,String> country;
    public static volatile SingularAttribute<Country,String> personaExt;
    //public static volatile SingularAttribute<Country,Set<String>> languages;
    public static volatile SingularAttribute<Country,String> username;
    public static volatile SingularAttribute<Country,String> telefono;
    //public static volatile SingularAttribute<Country,Set<String>> tags;


}
