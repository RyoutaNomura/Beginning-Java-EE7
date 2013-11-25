package org.agoncal.javaee7.chapter02.service;

import javax.inject.Inject;

import org.agoncal.javaee7.chapter02.annotation.Loggable;
import org.agoncal.javaee7.chapter02.annotation.ThirteenDigits;
import org.agoncal.javaee7.chapter02.pojo.Book;

@Loggable
public class BookService {

	@Inject @ThirteenDigits
	private NumberGenerator numberGenerator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
