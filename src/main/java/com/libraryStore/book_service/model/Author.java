package com.libraryStore.book_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "author_firstName", nullable = false)
    private String authorFirstName;
    @Column(name = "author_lastName", nullable = false)
    private String authorLastName;
    @Column(name = "author_book", nullable = false)
    private String authorBook;

    // Getters
    public long getId() {
        return id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getAuthorBook() {
        return authorBook;
    }



    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }



}
