package com.libraryStore.book_service.service.impl;


import com.libraryStore.book_service.model.Book;
import com.libraryStore.book_service.repository.BookRepository;
import com.libraryStore.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    //save employee in database
    @Override
    public Book saveBook(Book Book){
        return BookRepository.save(Book);
    }

    //get all employee form database
    @Override
    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }

    //get employee using id
    @Override
    public Book getBookById(long id) {
        Optional<Book> Book =  BookRepository.findById(id);
        if(Book.isPresent()){
            return Book.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update employee
    @Override
    public Book updateBook(Book Book, long id) {
        Book existingBook = BookRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingBook.setBookName(Book.getBookName());
        existingBook.setLocation(Book.getLocation());
        existingBook.setPrincipalName(Book.getPrincipalName());
        // save
        BookRepository.save(existingBook);
        return existingBook;
    }

    //delete employee
    @Override
    public void deleteBook(long id) {
        //check
        BookRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        BookRepository.deleteById(id);
    }
}
