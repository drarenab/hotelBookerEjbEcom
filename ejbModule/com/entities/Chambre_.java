package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-23T14:32:16.680+0200")
@StaticMetamodel(Chambre.class)
public class Chambre_ {
	public static volatile SingularAttribute<Chambre, Long> id;
	public static volatile SingularAttribute<Chambre, Long> numero;
	public static volatile SingularAttribute<Chambre, Integer> nbLits;
	public static volatile SingularAttribute<Chambre, Long> etage;
	public static volatile SingularAttribute<Chambre, Integer> etat;
	public static volatile SingularAttribute<Chambre, Float> prix;
	public static volatile SingularAttribute<Chambre, Hotel> hotel;
	public static volatile CollectionAttribute<Chambre, Photos> photos;
	public static volatile CollectionAttribute<Chambre, Reservation> reservationsChambre;
}
