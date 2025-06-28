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
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_title", nullable = false)
    private String bookTitle;
    @Column(name = "book_code", nullable = false)
    private String bookCode;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @ManyToOne
    @JoinColumn(name = "retail_id")
    private Retail retail;

    // Getters
    public long getId() {
        return id;
    }

    public String getbookTitle() {
        return bookTitle;
    }

    public String getbookCode() {
        return bookCode;
    }

    public Author getAuthor() {
        return author;
    }

    public Retail getRetail() {
        return retail;
    }



    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setRetail(Retail retail) {
        this.retail = retail;
    }




}
