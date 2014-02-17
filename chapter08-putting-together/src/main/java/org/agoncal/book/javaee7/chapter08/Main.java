package org.agoncal.book.javaee7.chapter08;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

	public static void main(String[] args) throws NamingException {

		Context ctx = new InitialContext();
		BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/chapter08-putting-together-0.0.1-SNAPSHOT/BookEJB"
				+ "!org.agoncal.book.javaee7.chapter08.BookEJBRemote");

		List<Book> books = bookEJB.findBooks();
		for (Book aBook : books) {
			System.out.println(aBook);
		}

		Book book = new Book("H2G2", 12.5F, "Scifi book", "1-24561-799-0", 354, false);

		book = bookEJB.createBook(book);
		System.out.println("Book created : " + book);

		book.setTitle("H2G2");
		book = bookEJB.updateBook(book);
		System.out.println("Book updated : " + book);

		bookEJB.deleteBook(book);
		System.out.println("Book deleted");
	}

}
