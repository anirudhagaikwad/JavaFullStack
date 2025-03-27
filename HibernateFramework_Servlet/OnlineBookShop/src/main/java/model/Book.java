package model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer bookId;

@Column(nullable = false, length = 100)
private String title;

@ManyToOne
@JoinColumn(name = "author_id", nullable = false)
private Author author;

@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
private Category category;

@Column(nullable = false, precision = 10, scale = 2)
private BigDecimal price;

@Column(nullable = false)
private Integer stock;

@Column(unique = true, length = 13)
private String isbn;

@OneToMany(mappedBy = "book")
private List<OrderItem> orderItems;

public Book() {
}

public Book(String title, Author author, Category category, BigDecimal price, Integer stock, String isbn) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.price = price;
    this.stock = stock;
    this.isbn = isbn;
}

public Book(Integer bookId, String title, Author author, Category category, BigDecimal price, Integer stock, String isbn) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.category = category;
    this.price = price;
    this.stock = stock;
    this.isbn = isbn;
}

public Integer getBookId() {
	return bookId;
}

public void setBookId(Integer bookId) {
	this.bookId = bookId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public BigDecimal getPrice() {
	return price;
}

public void setPrice(BigDecimal price) {
	this.price = price;
}

public Integer getStock() {
	return stock;
}

public void setStock(Integer stock) {
	this.stock = stock;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public List<OrderItem> getOrderItems() {
	return orderItems;
}

public void setOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
}


}

