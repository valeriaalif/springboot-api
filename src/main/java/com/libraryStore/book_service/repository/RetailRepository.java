package com.libraryStore.book_service.repository;

import com.libraryStore.book_service.model.Retail;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RetailRepository extends JpaRepository<Retail, Long> {

}
