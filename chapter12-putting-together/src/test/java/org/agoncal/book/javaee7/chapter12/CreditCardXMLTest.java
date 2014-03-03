package org.agoncal.book.javaee7.chapter12;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.jsp.JspApplicationContext;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class CreditCardXMLTest {

	public static final String creditCardXML =
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
			+ "<creditCard number=\"12345678\">"
			+ "<expiry_date>10/14</expiry_date>"
			+ "<control_number>566</control_number>"
			+ "<type>Visa</type>"
			+ "</creditCard>";


	@Test
	public void shouldMarshallACreditCarD() throws JAXBException {

		CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");

		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(CreditCard.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(creditCard, writer);

		System.out.println(writer);

		assertEquals(creditCardXML.replaceAll("(\\s|\\r|\\n)", ""), writer.toString().replaceAll("(\\s|\\r|\\n)", ""));
	}

	public void shouldUnmarshallACreditCard() throws JAXBException {

		StringReader reader = new StringReader(creditCardXML);
		JAXBContext context = JAXBContext.newInstance(CreditCard.class);
		Unmarshaller u = context.createUnmarshaller();
		CreditCard creditCard = (CreditCard) u.unmarshal(reader);

		assertEquals("12345678", creditCard.getNumber());
		assertEquals("10/14", creditCard.getNumber());
		assertEquals((Object)566,  creditCard.getControlNumber());
		assertEquals("Visa", creditCard.getType());
	}
}
