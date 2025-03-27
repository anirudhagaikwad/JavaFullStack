package model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer authorId;

@Column(nullable = false, length = 50)
private String firstName;

@Column(nullable = false, length = 50)
private String lastName;

private String bio;

@OneToMany(mappedBy = "author")
private List<Book> books;

public Author() {
}

public Author(String firstName, String lastName, String bio) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bio = bio;
}

public Author(Integer authorId, String firstName, String lastName, String bio) {
    this.authorId = authorId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.bio = bio;
}

public Integer getAuthorId() {
	return authorId;
}

public void setAuthorId(Integer authorId) {
	this.authorId = authorId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getBio() {
	return bio;
}

public void setBio(String bio) {
	this.bio = bio;
}

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}


}

