package com.libraryStore.book_service.service;

import com.libraryStore.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.libraryStore.book_service.model.Book;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(long id);
    Book createBook(Book book);
    Book createBookWithAuthor(long authorId, Book book);
    Book assignRetailToBook(long bookId, long retailId);
    Book updateBook(long id, Book updatedBook);
    void deleteBook(long id);
}
