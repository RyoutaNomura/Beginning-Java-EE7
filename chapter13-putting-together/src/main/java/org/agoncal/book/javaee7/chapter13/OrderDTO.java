package org.agoncal.book.javaee7.chapter13;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * This class is DTO represents order information.
 * @author RyoutaNomura
 *
 */
public class OrderDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Date creationDate;
	private String customerName;
	private BigDecimal totalAmount;

	public OrderDTO() {}

	public OrderDTO(Long orderId, Date creationDate, String customerName, BigDecimal totalAmount) {
		this.orderId = orderId;
		this.creationDate = creationDate;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


}
