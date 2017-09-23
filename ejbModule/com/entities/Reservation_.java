package com.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.825+0200")
@StaticMetamodel(Reservation.class)
public class Reservation_ {
	public static volatile SingularAttribute<Reservation, Long> id;
	public static volatile SingularAttribute<Reservation, Date> dateDeb;
	public static volatile SingularAttribute<Reservation, Date> dateFin;
	public static volatile SingularAttribute<Reservation, Integer> nbEnfant;
	public static volatile SingularAttribute<Reservation, Integer> nbAdulte;
	public static volatile SingularAttribute<Reservation, Utilisateur> utilisateur;
	public static volatile SingularAttribute<Reservation, Chambre> chambre;
}
