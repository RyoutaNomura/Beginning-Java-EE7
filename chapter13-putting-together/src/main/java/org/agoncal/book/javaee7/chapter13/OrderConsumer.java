package org.agoncal.book.javaee7.chapter13;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class OrderConsumer {
	public static void main(String[] args) throws NamingException {

		Properties env = new Properties();

		System.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
		System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

//		env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
		env.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		env.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
		env.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		InitialContext jndiContext = new InitialContext(env);

		ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext
				.lookup("jms/javaee7/ConnectionFactory");
		Destination topic = (Destination) jndiContext
				.lookup("jms/javaee7/Topic");

		try (JMSContext jmsContext = connectionFactory.createContext()) {
			while (true) {
				OrderDTO order = jmsContext.createConsumer(topic).receiveBody(
						OrderDTO.class);
				System.out.println("Order recieved: " + order);
			}
		}
	}
}
