package org.agoncal.javaee7.chapter02.main;

import org.agoncal.javaee7.chapter02.pojo.Book;
import org.agoncal.javaee7.chapter02.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

	public static void main(String[] args) {
		Weld weld = new Weld();
//		for (int i=0;i<100;i++) {
			WeldContainer container = weld.initialize();

			BookService bookService = container.instance().select(BookService.class).get();

			Book book = bookService.createBook("No Longer Human", 10.13f, String.valueOf(0));

			weld.shutdown();
//		}
	}

}
