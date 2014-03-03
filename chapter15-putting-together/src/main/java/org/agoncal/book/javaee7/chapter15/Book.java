package org.agoncal.book.javaee7.chapter15;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@XmlRootElement
@NamedQuery(name = Book.FIND_ALL, query = "SELECT b FROM Book b")
@Data
@NoArgsConstructor
public class Book {

	public static final String FIND_ALL = "Book.findAll";

	@Id
	@GeneratedValue
	private String id;
	@Column(nullable = false)
	private String title;
	private Float price;
	@Column(length = 2000)
	private String description;
	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;

	public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}
}
