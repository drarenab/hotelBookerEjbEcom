package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-23T14:32:16.698+0200")
@StaticMetamodel(Roles.class)
public class Roles_ {
	public static volatile SingularAttribute<Roles, Long> id;
	public static volatile SingularAttribute<Roles, String> libelle;
	public static volatile CollectionAttribute<Roles, Utilisateur> utilisateur;
}
