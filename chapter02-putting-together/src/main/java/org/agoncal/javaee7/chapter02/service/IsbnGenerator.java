package org.agoncal.javaee7.chapter02.service;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.agoncal.javaee7.chapter02.annotation.Loggable;
import org.agoncal.javaee7.chapter02.annotation.ThirteenDigits;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Loggable
	@Override
	public String generateNumber() {
		String isbn = "13-84356" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN:" + isbn);
		return isbn;
	}
}
