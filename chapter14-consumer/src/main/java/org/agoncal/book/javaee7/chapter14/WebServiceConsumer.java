package org.agoncal.book.javaee7.chapter14;

import javax.xml.ws.WebServiceRef;

public class WebServiceConsumer {

	@WebServiceRef
	private static CardValidatorService cardValidatorService;

	public static void main(String[] args) {
	CreditCard creditCard = new CreditCard();
	creditCard.setNumber("12341234");
	creditCard.setExpiryDate("10/12");
	creditCard.setType("VISA");
	creditCard.setControlNumber(1234);

	Validator cardValidator = cardValidatorService.getCardValidatorPort();
	System.out.println(cardValidator.validate(creditCard));
	}
}
