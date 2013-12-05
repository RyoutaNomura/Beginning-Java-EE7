package org.agoncal.book.javaee7.chapter04;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NamedQueries({
@NamedQuery(name="findAllBooks", query="SELECT b FROM Book b"),
@NamedQuery(name="findBookH2G2", query="SELECT b FROM Book b WHERE b.title='H2G2'" )
})
public class Book {

	@Id @GeneratedValue
	private Long id;

	@NotNull
	private String title;

	private BigDecimal price;

	@Size(min=10, max=2000)
	private String description;

	private String isbn;

	private Integer numberOfPage;

	private boolean illustrations;

	public Book() {

	}

	/**
	 * @param title
	 * @param description
	 * @param price
	 * @param isbn
	 * @param numberOfPage
	 * @param illustrations
	 */
	public Book(String title, String description, BigDecimal price,
			String isbn, int numberOfPage, boolean illustrations) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.numberOfPage = numberOfPage;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public boolean isIllustrations() {
		return illustrations;
	}

	public void setIllustrations(boolean illustrations) {
		this.illustrations = illustrations;
	}


}
