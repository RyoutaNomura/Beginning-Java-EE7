package org.agoncal.book.javaee7.chapter03.bean;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.agoncal.book.javaee7.chapter03.bean.Customer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

	private static ValidatorFactory vf;
	private static Validator validator;

	@BeforeClass
	public static void init() {
		vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@AfterClass
	public static void close() {
		vf.close();
	}

	@Test
	public void shouldRaiseNoConstraintViolation() {
		Customer customer = new Customer("John", "Smith", "jsmith@gmail.com");
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(0, violations.size());
	}

	@Test
	public void shouldRaiseConstraintViolationCauseInvalidEmail() {
		Customer customer = new Customer("John", "Smith", "DummyEmail");
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(1, violations.size());
		assertEquals("Email address doesn't look good", violations.iterator().next().getMessage());
		assertEquals("DummyEmail", violations.iterator().next().getInvalidValue());
		assertEquals("{org.agoncal.book.javaee7.Email.message}",violations.iterator().next().getMessageTemplate());
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldRaiseConstraintViolationCauseNullFirstName() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();

		try {
			Customer customer = container.instance().select(Customer.class).get();
			customer.setFirstName(null);
		} finally {
			weld.shutdown();
		}
	}

	@Test
	public void canSetNotNullValueToFirstName() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();

		try {
			Customer customer = container.instance().select(Customer.class).get();
			String expected = "FirstName";
			customer.setFirstName(expected);
			assertEquals(expected, customer.getFirstName());
		} finally {
			weld.shutdown();
		}
	}
}
