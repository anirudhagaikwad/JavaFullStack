package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer categoryId;
 
 @Column(nullable = false, unique = true, length = 50)
 private String name;
 
 private String description;
 
 @OneToMany(mappedBy = "category")
 private List<Book> books;

 public Category() {
 }

 public Category(String name, String description) {
     this.name = name;
     this.description = description;
 }
 
public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}
 
 
}



