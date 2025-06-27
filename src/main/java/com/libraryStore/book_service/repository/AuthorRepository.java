package com.libraryStore.book_service.repository;

import com.libraryStore.book_service.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
