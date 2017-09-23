package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.824+0200")
@StaticMetamodel(Photos.class)
public class Photos_ {
	public static volatile SingularAttribute<Photos, Long> id;
	public static volatile SingularAttribute<Photos, Long> nom;
	public static volatile SingularAttribute<Photos, String> url;
	public static volatile SingularAttribute<Photos, Chambre> chambre;
}
