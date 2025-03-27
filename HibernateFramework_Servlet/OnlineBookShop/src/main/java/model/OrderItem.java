package model;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Order_Items")
public class OrderItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer orderItemId;

@ManyToOne
@JoinColumn(name = "order_id", nullable = false)
private Order order;

@ManyToOne
@JoinColumn(name = "book_id", nullable = false)
private Book book;

@Column(nullable = false)
private Integer quantity;

@Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
private BigDecimal unitPrice;

public OrderItem() {
}

public OrderItem(Order order, Book book, Integer quantity, BigDecimal unitPrice) {
    this.order = order;
    this.book = book;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
}

public OrderItem(Integer orderItemId, Order order, Book book, Integer quantity, BigDecimal unitPrice) {
    this.orderItemId = orderItemId;
    this.order = order;
    this.book = book;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
}

public Integer getOrderItemId() {
	return orderItemId;
}

public void setOrderItemId(Integer orderItemId) {
	this.orderItemId = orderItemId;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public BigDecimal getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
}


}
