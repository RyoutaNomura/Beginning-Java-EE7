package org.agoncal.book.javaee7.chapter03.bean;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.agoncal.book.javaee7.chapter03.bean.Address;
import org.junit.Test;

public class AddressTest {
	@Test
	public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Address address = new Address("233 Spring Street", "New York", "NY",
				"DummyZip", "USA");
		Set<ConstraintViolation<Address>> violations = validator
				.validate(address);
		assertEquals(1, violations.size());
		vf.close();
	}
}
