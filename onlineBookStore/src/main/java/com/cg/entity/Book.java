package com.cg.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="book")
public class Book {
	public Book(int book_id, String title, String author, String description, int iSBN, double price, boolean icon) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.description = description;
		ISBN = iSBN;
		this.price = price;
		//this.published_Date = published_Date;
		this.icon = icon;
	}
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@ManyToOne
	//@JsonIgnore
	//@JoinColumn(name="CategoryId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity=Category.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CategoryName")
	public Category category;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	private int book_id;
	@Column(length=128)
	private String title;
	@Column(length=64)
	private String author;
	@Column(length=200)
	private String description;
	@Column(length=10)
	private int ISBN;
	@Column(length=10)
	private double price;
	private Date published_Date;
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private boolean icon;
	
	/*public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}*/
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPublished_Date() {
		return published_Date;
	}
	public void setPublished_Date(Date published_Date) {
		this.published_Date = published_Date;
	}
	public boolean getIcon() {
		return icon;
	}
	public void setIcon(boolean icon) {
		this.icon = icon;
	}
	

}
