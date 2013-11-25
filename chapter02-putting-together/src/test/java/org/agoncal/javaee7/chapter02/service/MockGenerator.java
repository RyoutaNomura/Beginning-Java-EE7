package org.agoncal.javaee7.chapter02.service;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.agoncal.javaee7.chapter02.annotation.Loggable;
import org.agoncal.javaee7.chapter02.annotation.ThirteenDigits;
import org.agoncal.javaee7.chapter02.service.NumberGenerator;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Loggable
	@Override
	public String generateNumber() {
		String mock = "MOCK-" + Math.abs(new Random().nextInt());
		logger.info("Generated Mock:" + mock);
		return mock;
	}

}
