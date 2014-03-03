package org.agoncal.book.javaee7.chapter11;

import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

@Named
@Stateless
@DataSourceDefinition(name = "java:global/jdbc/chapter11DS",
className = "org.apache.derby.jdbc.EmbeddedDriver",
url = "jdbc:derby:memory:lab11DB;create=true;user=app;password=app")
public class BookEJB {

	@Inject
	private EntityManager em;

	public List<Book> findAllBooks() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		Root<Book> c = criteriaQuery.from(Book.class);
		criteriaQuery.select(c);
		return em.createQuery(criteriaQuery).getResultList();
	}

	public Book findBookById(Long id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		Root<Book> c = criteriaQuery.from(Book.class);
		criteriaQuery.select(c).where(builder.equal(c.get(Book_.id), id));
		return em.createQuery(criteriaQuery).getResultList().get(0);
	}

	public @NotNull Book createBook(@NotNull Book book) {
		em.persist(book);
		return book;
	}

}
