package com.libraryStore.book_service.controller;

import com.libraryStore.book_service.model.Author;
import com.libraryStore.book_service.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return authorRepository.findById(id).orElse(null);
    }


    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }


    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author updatedAuthor) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setAuthorFirstName(updatedAuthor.getAuthorFirstName());
            author.setAuthorLastName(updatedAuthor.getAuthorLastName());
            return authorRepository.save(author);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable long id) {
        authorRepository.deleteById(id);
        return "Author deleted with id: " + id;
    }

}
