package org.agoncal.book.javaee7.chapter12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represent Credit Card.
 * Convertion to/from XML enabled JAXB
 * @author RyoutaNomura
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

	@XmlAttribute
	private String number;
	@XmlElement(name="expiry_date")
	private String expiryDate;
	@XmlElement(name="control_number")
	private Integer controlNumber;
	private String type;

	/**
	 * Default Constructor
	 */
	public CreditCard() {

	}

	/**
	 * Constructor
	 * @param number
	 * @param expiryDate
	 * @param controlNumber
	 * @param type
	 */
	public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
		this.number = number;
		this.expiryDate = expiryDate;
		this.controlNumber = controlNumber;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}
