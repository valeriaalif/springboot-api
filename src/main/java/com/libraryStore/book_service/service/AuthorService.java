package com.libraryStore.book_service.service;

import com.libraryStore.book_service.model.Author;

import java.util.List;
public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(long id);

    Author createAuthor(Author author);

    Author updateAuthor(long id, Author updatedAuthor);

    void deleteAuthor(long id);
}
