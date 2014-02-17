package org.agoncal.book.javaee7.chapter08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Test;

public class BookEJBIT {
//	private GlassFish glassfish = null;
//	@Before
//	public void before() {
//		GlassFishProperties glassfishProperties = new GlassFishProperties();
//		try {
//			glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
//			glassfish.start();
//		} catch (GlassFishException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//	}
//
//	public void after() {
//		try {
//			glassfish.stop();
//			glassfish.dispose();
//		} catch (GlassFishException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//	}
	@Test
	public void shouldCreateABook() {

		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File[] {
				new File("target/test-classes"), new File("target/classes")});

		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
			Context ctx = ec.getContext();
			assertNotNull(ctx.lookup("java:global/jdbc/chapter08DS"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter08.BookEJBRemote"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter08.BookEJB"));

			BookEJB bookEJB = (BookEJB)ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter08.BookEJB");

			assertEquals(2,  bookEJB.findBooks().size());

			Book book = new Book("H2G2", 12.5F, "Scifi book", "1234567", 354, false);
			book = bookEJB.createBook(book);
			assertNotNull("ID should not be null", book.getId());

			assertEquals(3, bookEJB.findBooks().size());

			bookEJB.deleteBook(book);

			assertEquals(2, bookEJB.findBooks().size());

		} catch (NamingException e) {
			e.printStackTrace();
			fail();
		}
	}
}
