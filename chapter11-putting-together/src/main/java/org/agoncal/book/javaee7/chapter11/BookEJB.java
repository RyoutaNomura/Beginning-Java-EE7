package org.agoncal.book.javaee7.chapter11;

import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		return query.getResultList();
	}

	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}

	public @NotNull Book createBook(@NotNull Book book) {
		em.persist(book);
		return book;
	}

}
