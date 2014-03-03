package org.agoncal.book.javaee7.chapter13;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class OrderProducer {

	public static void main(String[] args) throws NamingException {

		System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
		System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		Properties env = new Properties();
		env.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		env.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
		env.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		Context jndiContext = new InitialContext();
		ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
		Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

		try (JMSContext jmsContext = connectionFactory.createContext()) {
			int cnt = 0;
			while (true) {
				Random rand = new Random(System.currentTimeMillis());
				BigDecimal totalAmount = new BigDecimal(rand.nextInt());
				OrderDTO order = new OrderDTO(1234l, new Date(), "Betty Moreau", totalAmount);

				jmsContext.createProducer().setProperty("orderAmount", totalAmount.floatValue()).send(topic, order);
//				if (cnt++ > 100) {
//					break;
//				}

			}
		}
	}
}
