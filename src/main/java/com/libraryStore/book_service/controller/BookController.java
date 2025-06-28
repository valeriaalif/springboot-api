package com.libraryStore.book_service.controller;


import com.libraryStore.book_service.model.Author;
import com.libraryStore.book_service.model.Book;
import com.libraryStore.book_service.model.Retail;
import com.libraryStore.book_service.repository.RetailRepository;
import com.libraryStore.book_service.repository.AuthorRepository;
import com.libraryStore.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RetailRepository retailRepository;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookRepository.findById(id).orElse(null);
    }


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    @PostMapping("/author/{authorId}")
    public Book createBookWithAuthor(@PathVariable long authorId, @RequestBody Book book) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            return bookRepository.save(book);
        }
        return null;
    }


    @PutMapping("/{bookId}/retail/{retailId}")
    public Book assignRetailToBook(@PathVariable long bookId, @PathVariable long retailId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Retail retail = retailRepository.findById(retailId).orElse(null);

        if (book != null && retail != null) {
            book.setRetail(retail);
            return bookRepository.save(book);
        }
        return null;
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setBookTitle(updatedBook.getbookTitle());
            book.setBookCode(updatedBook.getbookCode());
            book.setAuthor(updatedBook.getAuthor());
            book.setRetail(updatedBook.getRetail());
            return bookRepository.save(book);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "Book deleted with id: " + id;
    }
}
