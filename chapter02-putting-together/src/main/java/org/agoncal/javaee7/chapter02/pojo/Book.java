package org.agoncal.javaee7.chapter02.pojo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Book {

	private String title;
	private Float price;
	private String description;
	private String number;

	public Book(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
