package com.libraryStore.book_service.service.impl;


import com.libraryStore.book_service.model.Author;
import com.libraryStore.book_service.repository.AuthorRepository;
import com.libraryStore.book_service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(long id, Author updatedAuthor) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            author.setAuthorFirstName(updatedAuthor.getAuthorFirstName());
            author.setAuthorLastName(updatedAuthor.getAuthorLastName());
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }
}
