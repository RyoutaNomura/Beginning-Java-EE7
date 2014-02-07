package org.agoncal.book.javaee7.chapter08;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {

	@Produces
	@PersistenceContext(unitName="chapter08PU")
	private EntityManager em;
}
