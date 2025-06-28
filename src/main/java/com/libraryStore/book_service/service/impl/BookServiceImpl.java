package com.libraryStore.book_service.service.impl;


import com.libraryStore.book_service.model.Author;
import com.libraryStore.book_service.model.Book;
import com.libraryStore.book_service.model.Retail;
import com.libraryStore.book_service.repository.AuthorRepository;
import com.libraryStore.book_service.repository.BookRepository;
import com.libraryStore.book_service.repository.RetailRepository;
import com.libraryStore.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RetailRepository retailRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book createBookWithAuthor(long authorId, Book book) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            book.setAuthor(author.get());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book assignRetailToBook(long bookId, long retailId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Retail> retail = retailRepository.findById(retailId);

        if (book.isPresent() && retail.isPresent()) {
            Book b = book.get();
            b.setRetail(retail.get());
            return bookRepository.save(b);
        }
        return null;
    }

    @Override
    public Book updateBook(long id, Book updatedBook) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setBookTitle(updatedBook.getbookTitle());
            book.setBookCode(updatedBook.getbookCode());
            book.setAuthor(updatedBook.getAuthor());
            book.setRetail(updatedBook.getRetail());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
