package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-23T14:32:16.694+0200")
@StaticMetamodel(Hotel.class)
public class Hotel_ {
	public static volatile SingularAttribute<Hotel, Long> id;
	public static volatile SingularAttribute<Hotel, String> nom;
	public static volatile SingularAttribute<Hotel, String> adresse;
	public static volatile SingularAttribute<Hotel, String> ville;
	public static volatile SingularAttribute<Hotel, String> region;
	public static volatile SingularAttribute<Hotel, String> codePostal;
	public static volatile SingularAttribute<Hotel, String> nbEtoile;
	public static volatile SingularAttribute<Hotel, ChaineHotel> chaineHotel;
	public static volatile CollectionAttribute<Hotel, Chambre> chambres;
	public static volatile CollectionAttribute<Hotel, PhotoHotel> photos;
}
