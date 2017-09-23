package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-22T22:30:40.823+0200")
@StaticMetamodel(PhotoHotel.class)
public class PhotoHotel_ {
	public static volatile SingularAttribute<PhotoHotel, Long> id;
	public static volatile SingularAttribute<PhotoHotel, Long> nom;
	public static volatile SingularAttribute<PhotoHotel, String> url;
	public static volatile SingularAttribute<PhotoHotel, Hotel> hotel;
}
