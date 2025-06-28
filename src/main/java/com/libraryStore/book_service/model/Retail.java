package com.libraryStore.book_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "retail")
public class Retail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "retail_Name", nullable = false)
    private String retailName;
    @OneToMany(mappedBy = "retail", cascade = CascadeType.ALL)
    private List<Book> books;

    // Getters
    public long getId() {
        return id;
    }

    public String getRetailName() {
        return retailName;
    }

    public List<Book> getBooks() {
        return books;
    }




    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setRetailName(String retailName) {
        this.retailName = retailName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
