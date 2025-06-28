package com.libraryStore.book_service.controller;
import com.libraryStore.book_service.model.Retail;
import com.libraryStore.book_service.repository.RetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retails")
public class RetailController {

    @Autowired
    private RetailRepository retailRepository;


    @GetMapping
    public List<Retail> getAllRetails() {
        return retailRepository.findAll();
    }


    @GetMapping("/{id}")
    public Retail getRetailById(@PathVariable long id) {
        return retailRepository.findById(id).orElse(null);
    }


    @PostMapping
    public Retail createRetail(@RequestBody Retail retail) {
        return retailRepository.save(retail);
    }


    @PutMapping("/{id}")
    public Retail updateRetail(@PathVariable long id, @RequestBody Retail updatedRetail) {
        Retail retail = retailRepository.findById(id).orElse(null);
        if (retail != null) {
            retail.setRetailName(updatedRetail.getRetailName());
            return retailRepository.save(retail);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public String deleteRetail(@PathVariable long id) {
        retailRepository.deleteById(id);
        return "Retail deleted with id: " + id;
    }
}
