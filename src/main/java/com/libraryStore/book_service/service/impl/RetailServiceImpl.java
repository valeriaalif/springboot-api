package com.libraryStore.book_service.service.impl;
import com.libraryStore.book_service.model.Retail;
import com.libraryStore.book_service.repository.RetailRepository;
import com.libraryStore.book_service.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public class RetailServiceImpl implements RetailService {

    @Autowired
    private RetailRepository retailRepository;

    @Override
    public List<Retail> getAllRetails() {
        return retailRepository.findAll();
    }

    @Override
    public Retail getRetailById(long id) {
        return retailRepository.findById(id).orElse(null);
    }

    @Override
    public Retail createRetail(Retail retail) {
        return retailRepository.save(retail);
    }

    @Override
    public Retail updateRetail(long id, Retail updatedRetail) {
        Optional<Retail> retailOptional = retailRepository.findById(id);
        if (retailOptional.isPresent()) {
            Retail retail = retailOptional.get();
            retail.setRetailName(updatedRetail.getRetailName());
            return retailRepository.save(retail);
        }
        return null;
    }

    @Override
    public void deleteRetail(long id) {
        retailRepository.deleteById(id);
    }
}
