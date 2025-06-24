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
@Table(name = "retail")
public class Retail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "retail_Name", nullable = false)
    private String retailName;
    @Column(name = "retail_Book", nullable = false)
    private String retailBook;

    // Getters
    public long getId() {
        return id;
    }

    public String getRetailName() {
        return retailName;
    }

    public String getRetailBook() {
        return retailBook;
    }



    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setRetailName(String retailName) {
        this.retailName = retailName;
    }

    public void setRetailBook(String retailBook) {
        this.retailBook = retailBook;
    }


}
