package org.agoncal.book.javaee7.chapter11;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-17T10:31:24.319+0900")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Float> price;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, Integer> nbOfPage;
	public static volatile SingularAttribute<Book, Boolean> illustrations;
}
