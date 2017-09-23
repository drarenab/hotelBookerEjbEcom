package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.827+0200")
@StaticMetamodel(Roles.class)
public class Roles_ {
	public static volatile SingularAttribute<Roles, Long> id;
	public static volatile SingularAttribute<Roles, String> libelle;
	public static volatile CollectionAttribute<Roles, Utilisateur> utilisateur;
}
