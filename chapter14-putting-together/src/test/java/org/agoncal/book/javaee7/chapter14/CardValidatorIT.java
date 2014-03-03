package org.agoncal.book.javaee7.chapter14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.Test;

public class CardValidatorIT {

	@Test
	public void shouldCheckCreditCardValidity() throws MalformedURLException {

		Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());

		assertTrue(endpoint.isPublished());
		assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

		URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
		String namespaceURI = "http://chapter14.javaee7.book.agoncal.org/";
		String servicePart = "CardValidatorService";
		String portName = "CardValidatorPort";

		QName serviceQN = new QName(namespaceURI, servicePart);
		QName portQN = new QName(namespaceURI, portName);

		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		Validator cardvalidator = service.getPort(portQN, Validator.class);

		CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
		assertTrue("Credit card should be valid", cardvalidator.validate(creditCard));

		creditCard.setNumber("12341233");
		assertFalse("Credit card should not be valid", cardvalidator.validate(creditCard));

		endpoint.stop();
		assertFalse(endpoint.isPublished());
	}

}
