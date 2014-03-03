package org.agoncal.book.javaee7.chapter14;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

public class CreditValidatorTest {

	@Test
	public void shouldCheckCreditCardValidity() {
		CardValidator cardValidator = new CardValidator();

		CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");

		assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

		creditCard.setNumber("12341233");
		assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
	}
}
