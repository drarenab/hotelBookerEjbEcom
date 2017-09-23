package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.828+0200")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
	public static volatile SingularAttribute<Utilisateur, Long> id;
	public static volatile SingularAttribute<Utilisateur, String> nom;
	public static volatile SingularAttribute<Utilisateur, String> prenom;
	public static volatile SingularAttribute<Utilisateur, String> adresse;
	public static volatile SingularAttribute<Utilisateur, String> ville;
	public static volatile SingularAttribute<Utilisateur, String> region;
	public static volatile SingularAttribute<Utilisateur, String> codePostal;
	public static volatile SingularAttribute<Utilisateur, String> sexe;
	public static volatile SingularAttribute<Utilisateur, String> numTel;
	public static volatile SingularAttribute<Utilisateur, String> email;
	public static volatile SingularAttribute<Utilisateur, String> password;
	public static volatile SingularAttribute<Utilisateur, Roles> role;
	public static volatile CollectionAttribute<Utilisateur, Reservation> reservations;
}
