package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import validator.zipcode.ZipCodeChecker;
import annotation.USA;
import annotation.ZipCode;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Inject @USA
	private ZipCodeChecker checker;

	private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");
	@Override
	public void initialize(ZipCode constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)){
			return false;
		}
		Matcher m = this.zipPattern.matcher(value);
		if (!m.matches()) {
			return false;
		}
		return this.checker.isZipCodeValid(value);
	}

}
