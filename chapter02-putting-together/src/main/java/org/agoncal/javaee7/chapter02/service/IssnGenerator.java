package org.agoncal.javaee7.chapter02.service;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.agoncal.javaee7.chapter02.annotation.EightDigits;
import org.agoncal.javaee7.chapter02.annotation.Loggable;

@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Loggable
	@Override
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN:" + issn);
		return issn;
	}
}
