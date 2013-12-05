package org.agoncal.book.javaee7.chapter04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookIntegrationTest {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("chapter04TestPU");

	private EntityManager em;
	private EntityTransaction tx;

	@Before
	public void initEntityManager() {
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() {
		if (em != null) {
			em.close();
		}
	}

	@Test
	public void shouldFindJavaEE7Book() {
		Book book = em.find(Book.class, 1001L);
		assertEquals("Beginning Java EE 7", book.getTitle());
	}

	@Test
	public void shouldCreateH2G2Book() {
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy",
				BigDecimal.valueOf(12.5), "1-84023-742-2", 354, false);

		tx.begin();
		em.persist(book);
		tx.commit();
		assertNotNull("ID should not be null", book.getId());

		book = em.createNamedQuery("findBookH2G2", Book.class)
				.getSingleResult();
		assertEquals("The Hitchhiker's Guide to the Galaxy",
				book.getDescription());
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldRaiseConstraintViolationCauseNullTitle() {
		Book book = new Book(null, "Null title, should fail",
				BigDecimal.valueOf(12.5F), "1-84023-742-2", 354, false);
		em.persist(book);
	}
}
