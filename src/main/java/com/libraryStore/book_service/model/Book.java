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
    @Column(name = "book_author", nullable = false)
    private String bookAuthor;
    @Column(name = "book_retailer", nullable = false)
    private String bookRetailer;

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

    public String getbookAuthor() {
        return bookAuthor;
    }

    public String getbookRetailer() {
        return bookRetailer;
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

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookRetailer(String bookRetailer) {
        this.bookRetailer = bookRetailer;
    }


}
