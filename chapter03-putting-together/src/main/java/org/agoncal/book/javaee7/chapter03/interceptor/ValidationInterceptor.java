package org.agoncal.book.javaee7.chapter03.interceptor;

import java.util.Set;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.agoncal.book.javaee7.chapter03.annotation.Validatable;
import org.slf4j.Logger;

@Interceptor
@Validatable
public class ValidationInterceptor {

	@Inject
	Logger logger;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = this.factory.getValidator();

	@AroundInvoke
	public Object validate(InvocationContext ic) throws Exception {

		ExecutableValidator executableVaridator = this.validator.forExecutables();

		Set<ConstraintViolation<Object>> violations = executableVaridator.validateParameters(ic.getTarget(), ic.getMethod(), ic.getParameters());
		if (violations.size() > 0) {
			for (ConstraintViolation<Object> violation : violations) {
				this.logger.error(String.format("%s %s", violation.getPropertyPath(),violation.getMessage()));
			}
			throw new IllegalArgumentException();
		}

		return ic.proceed();
	}
}
