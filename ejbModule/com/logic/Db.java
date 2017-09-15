package com.logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Room;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Session Bean implementation class Db
 */

@Stateless
@LocalBean
public class Db implements DbRemote {

	// Injected database connection:
    @PersistenceContext(name="primary")
    private EntityManager em;
 
   //  Retrieves all the guests:
    @Override
    public java.util.List<Room> getAllRooms() {
        TypedQuery<Room> query = em.createQuery(
            "SELECT g FROM Room g ORDER BY g.id", Room.class);
        return query.getResultList();
    }

}
