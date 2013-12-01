package org.agoncal.javaee7.chapter02.main;

import static org.junit.Assert.*;

import org.agoncal.javaee7.chapter02.pojo.Book;
import org.agoncal.javaee7.chapter02.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class BookServiceTest {
	@Test
	public void shouldCheckNumberIsMOCK() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.instance()
				.select(BookService.class).get();
		Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
		assertTrue(book.getNumber().startsWith("MOCK"));
		weld.shutdown();
	}
}