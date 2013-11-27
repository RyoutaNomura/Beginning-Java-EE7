import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Customer;

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

	@Test
	public void shouldRaiseConstraintViolationCauseNullFirstName() {
		Customer customer = new Customer();
		customer.setFirstName(null);
	}
}
