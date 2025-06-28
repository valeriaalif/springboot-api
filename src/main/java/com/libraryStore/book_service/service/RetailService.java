package com.libraryStore.book_service.service;

import com.libraryStore.book_service.model.Retail;

import java.util.List;
public interface RetailService {

    List<Retail> getAllRetails();

    Retail getRetailById(long id);

    Retail createRetail(Retail retail);

    Retail updateRetail(long id, Retail updatedRetail);

    void deleteRetail(long id);
}
