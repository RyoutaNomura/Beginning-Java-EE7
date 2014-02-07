package org.agoncal.book.javaee7.chapter08;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name="FIND_ALL", query="SELECT b FROM Book b")
public class Book implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Book.findAllBooks";

	@Id @GeneratedValue
	private long id;

	@NotNull @Column(nullable=false)
	private String title;
	private Float price;
	@Size(max=2000)	@Column(length=2000)
	private String description;
	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;

	public Book() {
		super();
	}

	public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getNbOfPage() {
		return nbOfPage;
	}
	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}
	public Boolean getIllustrations() {
		return illustrations;
	}
	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}
}
