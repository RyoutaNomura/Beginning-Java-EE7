package org.agoncal.book.javaee7.chapter13;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@JMSConnectionFactoryDefinition(name = "jms/javaee7/ConnectionFactory", className = "javax.jms.ConnectionFactory")
@JMSDestinationDefinition(name = "jms/javaee7/Topic", interfaceName = "javax.jms.Topic", destinationName = "jms_javaee7_Topic")
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000") })
public class ExpensiveOrderMDB implements MessageListener {

	@Override
	public void onMessage(Message paramMessage) {
		try {
			OrderDTO orderDTO = paramMessage.getBody(OrderDTO.class);
			System.out.println("Expensive order received: "
					+ orderDTO.toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
