package com.libraryStore.book_service.service;

import com.libraryStore.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.libraryStore.book_service.model.Book;
import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book updateBook(Book book,long id);
    void deleteBook(long id);

}
