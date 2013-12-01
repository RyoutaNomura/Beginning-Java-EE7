package org.agoncal.book.javaee7.chapter03.validator.zipcode;

import javax.enterprise.inject.Default;

import org.agoncal.book.javaee7.chapter03.annotation.USA;

@USA @Default
public class USAZipCodeChecker implements ZipCodeChecker {

	@Override
	public boolean isZipCodeValid(String value) {
		return true;
	}

}
