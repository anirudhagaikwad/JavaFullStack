package entity;


import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    public OrderItem() {}

    public OrderItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Getters
    public int getOrderItemId() { return orderItemId; }

    public Book getBook() { return book; }

    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return quantity * book.getPrice();
    }
}

