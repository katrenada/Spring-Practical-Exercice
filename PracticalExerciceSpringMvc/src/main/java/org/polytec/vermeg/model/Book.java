package org.polytec.vermeg.model;

import java.sql.Date;

//import java.sql.Date;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="price")
	private double price;
	
	@Column(name="date")
	private Date date;
	
	
	public Book() {
		super();
	}
	
	
	
	
//private long id;
//private String title;
//private String author;
//private double price;

public Book(long id, String title, String author, double price, Date date) {
	super();
	this.id = id;
	this.title = title;
	this.author = author;
	this.price = price;
	this.date = date;
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}




public Date getDate() {
	return date;
}




public void setDate(Date date) {
	this.date = date;
}

}
