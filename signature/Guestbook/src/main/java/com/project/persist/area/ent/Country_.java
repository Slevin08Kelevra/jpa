package com.project.persist.area.ent;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Country.class)
public class Country_ {

    public static volatile SingularAttribute<Country,Integer> id;
    public static volatile SingularAttribute<Country,String> code;
    public static volatile SingularAttribute<Country,String> name;

}
