package org.agoncal.book.javaee7.chapter08;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface BookEJBRemote {
	List<Book> findBooks();
	@NotNull Book createBook(@NotNull Book book);
	void deleteBook(Book book);
	@NotNull Book updateBook(@NotNull Book book);
}
