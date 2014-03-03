package org.agoncal.book.javaee7.chapter15;

import java.net.URI;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@DataSourceDefinition(className = "org.apache.derby.jdbc.EmbeddedDataSource",
name = "java:global/jdbc/chapter15DS",
user = "app",
password = "app",
databaseName = "chapter15DB",
properties = { "connectionAttributes=;create=true" })
@Path("/book")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Stateless
public class BookRestService {

	@PersistenceContext(unitName = "chapter15PU")
	private EntityManager em;
	@Context
	private UriInfo uriInfo;

	@POST
	public Response createBook(Book book) {
		if (book == null) {
			throw new BadRequestException();
		}
		this.em.persist(book);
		System.out.println("Created: " + book.toString());
		URI bookUri = this.uriInfo.getAbsolutePathBuilder().path(book.getId()).build();

		return Response.created(bookUri).build();
	}

	@GET
	@Path("{id}")
	public Response getBook(@PathParam("id") String id) {
		Book book = this.em.find(Book.class, id);

		if (book == null) {
			throw new NotFoundException();
		}
		return Response.ok(book).build();
	}

	@GET
	public Response getBooks() {
		TypedQuery<Book> query = this.em.createNamedQuery(Book.FIND_ALL, Book.class);
		Books books = new Books(query.getResultList());
		return Response.ok(books).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteBook(@PathParam("id") String id) {
		Book book = this.em.find(Book.class, id);

		if (book == null) {
			throw new NotFoundException();
		}

		this.em.remove(book);
		System.out.println("Deleted: " + book.toString());
		return Response.noContent().build();
	}
}
