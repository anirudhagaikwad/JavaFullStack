package model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer orderId;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;

@Column(name = "order_date")
private LocalDateTime orderDate = LocalDateTime.now();

@Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
private BigDecimal totalAmount;

@Column(nullable = false, length = 20)
private String status = "Pending";

@OneToMany(mappedBy = "order")
private List<OrderItem> orderItems;

public Order() {
}

public Order(User user, BigDecimal totalAmount, String status) {
    this.user = user;
    this.totalAmount = totalAmount;
    this.status = status;
}

public Order(Integer orderId, User user, BigDecimal totalAmount, String status) {
    this.orderId = orderId;
    this.user = user;
    this.totalAmount = totalAmount;
    this.status = status;
}
public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public LocalDateTime getOrderDate() {
	return orderDate;
}

public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
}

public BigDecimal getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(BigDecimal totalAmount) {
	this.totalAmount = totalAmount;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public List<OrderItem> getOrderItems() {
	return orderItems;
}

public void setOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
}


}

