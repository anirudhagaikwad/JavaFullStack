package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    // Constructors
    public Author() {}

    public Author(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
