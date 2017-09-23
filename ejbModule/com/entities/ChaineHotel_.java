package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.622+0200")
@StaticMetamodel(ChaineHotel.class)
public class ChaineHotel_ {
	public static volatile SingularAttribute<ChaineHotel, Long> id;
	public static volatile SingularAttribute<ChaineHotel, String> nom;
	public static volatile ListAttribute<ChaineHotel, Hotel> hotels;
}
