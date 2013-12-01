package org.agoncal.javaee7.chapter02.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggingProducer {

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
		logger.setLevel(Level.ALL);
		return logger;
	}
}
